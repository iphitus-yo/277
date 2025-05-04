package com.example.paranalog.worker

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.paranalog.data.AppDatabase
import com.example.paranalog.data.Checklist
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PdfGenerationWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    companion object {
        const val KEY_CHECKLIST_ID = "checklist_id"
        const val KEY_PDF_URI = "pdf_uri"
        const val KEY_CRT_NUMBER = "crt_number"
        const val KEY_DRIVER_FIRST_NAME = "driver_first_name"
        private const val TAG = "PdfGenerationWorker"
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val checklistId = inputData.getLong(KEY_CHECKLIST_ID, -1)
        if (checklistId == -1L) {
            Log.e(TAG, "Invalid checklist ID received.")
            return@withContext Result.failure()
        }

        val database = AppDatabase.getDatabase(applicationContext)
        val checklistDao = database.checklistDao()
        val checklist = checklistDao.getChecklistById(checklistId)

        if (checklist == null) {
            Log.e(TAG, "Checklist not found for ID: $checklistId")
            return@withContext Result.failure()
        }

        try {
            // Prepare data for Python script (ensure field names match Checklist.kt)
            val gson = Gson()
            val checklistJson = gson.toJson(checklist) // Convert the whole object

            // Define output PDF path
            val outputDir = File(applicationContext.filesDir, "pdfs")
            if (!outputDir.exists()) {
                outputDir.mkdirs()
            }
            // Use a unique name, e.g., based on ID and timestamp
            val timestampStr = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date(checklist.timestamp))
            val pdfFileName = "checklist_${checklistId}_${timestampStr}.pdf"
            val outputFile = File(outputDir, pdfFileName)

            // Define path to the Python script and template within the app's files dir
            // Assuming generate_pdf.py and checklist_template.html are copied there or accessible
            // For simplicity, let's assume they are in the main filesDir for now.
            // In a real app, you might copy them from assets on first run.
            val scriptPath = File(applicationContext.filesDir, "generate_pdf.py").absolutePath
            val templatePath = File(applicationContext.filesDir, "checklist_template.html").absolutePath
            // If template is in assets, adjust path accordingly or copy it first.
            // val templatePath = "file:///android_asset/checklist_template.html" // Might not work directly with WeasyPrint

            // Command to execute Python script
            // Pass JSON data as a command-line argument (ensure proper quoting/escaping if needed)
            // Or better: pass JSON via stdin
            val command = arrayOf(
                "python3",
                scriptPath,
                templatePath,
                outputFile.absolutePath
            )

            Log.d(TAG, "Executing command: ${command.joinToString(" ")}")
            Log.d(TAG, "Checklist JSON: $checklistJson")

            val process = ProcessBuilder(*command)
                .redirectErrorStream(true) // Combine stdout and stderr
                .start()

            // Write JSON data to the script's stdin
            process.outputStream.bufferedWriter().use { writer ->
                writer.write(checklistJson)
            }

            // Read script output/errors
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            var line: String?
            val outputLog = StringBuilder()
            while (reader.readLine().also { line = it } != null) {
                Log.d(TAG, "Script output: $line")
                outputLog.append(line).append("\n")
            }

            val exitCode = process.waitFor()
            Log.d(TAG, "Script exited with code: $exitCode")

            if (exitCode == 0 && outputFile.exists()) {
                Log.i(TAG, "PDF generated successfully at: ${outputFile.absolutePath}")

                // Update checklist status and PDF path in DB
                // Corrected: Use the 'update' method from the DAO
                val updatedChecklist = checklist.copy(pdfPath = outputFile.absolutePath, status = "generated_pdf")
                checklistDao.update(updatedChecklist)

                // Get content URI using FileProvider
                val pdfUri = FileProvider.getUriForFile(
                    applicationContext,
                    "${applicationContext.packageName}.provider",
                    outputFile
                )

                // Prepare output data for the next step (e.g., sending email)
                val outputData = workDataOf(
                    KEY_PDF_URI to pdfUri.toString(),
                    KEY_CRT_NUMBER to (checklist.diDueCrtMicDta ?: "N/A"), // Use correct field name
                    KEY_DRIVER_FIRST_NAME to (checklist.motorista?.split(" ")?.firstOrNull() ?: "Motorista") // Use correct field name
                )
                return@withContext Result.success(outputData)
            } else {
                Log.e(TAG, "PDF generation failed. Exit code: $exitCode. Output:\n$outputLog")
                // Corrected: Use the 'update' method from the DAO
                val updatedChecklist = checklist.copy(status = "pdf_error")
                checklistDao.update(updatedChecklist)
                return@withContext Result.failure()
            }

        } catch (e: Exception) {
            Log.e(TAG, "Error during PDF generation", e)
            // Corrected: Use the 'update' method from the DAO
            val updatedChecklist = checklist.copy(status = "pdf_error")
            checklistDao.update(updatedChecklist)
            return@withContext Result.failure()
        }
    }
}

