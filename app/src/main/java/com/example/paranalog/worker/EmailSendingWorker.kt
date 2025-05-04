package com.example.paranalog.worker

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.WorkerParameters
import com.example.paranalog.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.Properties
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart

class EmailSendingWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    companion object {
        const val KEY_CHECKLIST_ID = "checklist_id" // Need ID to update status
        const val KEY_PDF_PATH = "pdf_path"
        private const val TAG = "EmailSendingWorker"

        // --- Email Configuration (PLACEHOLDERS - MUST BE REPLACED) ---
        private const val EMAIL_HOST = "smtp.example.com" // e.g., smtp.gmail.com
        private const val EMAIL_PORT = "587" // e.g., 587 for TLS
        private const val EMAIL_USERNAME = "your_email@example.com" // Sender email address
        private const val EMAIL_PASSWORD = "your_app_password" // Sender email password (use App Password for Gmail)
        private const val RECIPIENT_EMAIL = "juniorrafael@icloud.com" // Target recipient
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val checklistId = inputData.getLong(KEY_CHECKLIST_ID, -1)
        val pdfPath = inputData.getString(KEY_PDF_PATH)

        if (checklistId == -1L || pdfPath.isNullOrBlank()) {
            Log.e(TAG, "Invalid input data received. Checklist ID: $checklistId, PDF Path: $pdfPath")
            return@withContext Result.failure()
        }

        val pdfFile = File(pdfPath)
        if (!pdfFile.exists()) {
            Log.e(TAG, "PDF file not found at path: $pdfPath")
            // Update status to indicate PDF missing?
            updateStatus(checklistId, "email_error_pdf_missing")
            return@withContext Result.failure() // Or maybe retry if it's a temporary issue?
        }

        // Update status to pending
        updateStatus(checklistId, "pending_email")

        try {
            val props = Properties().apply {
                put("mail.smtp.host", EMAIL_HOST)
                put("mail.smtp.port", EMAIL_PORT)
                put("mail.smtp.auth", "true")
                put("mail.smtp.starttls.enable", "true") // Use TLS
                // Add other properties if needed (e.g., SSL)
            }

            val session = Session.getInstance(props, object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD)
                }
            })

            // Create email message
            val message = MimeMessage(session).apply {
                setFrom(InternetAddress(EMAIL_USERNAME))
                addRecipient(Message.RecipientType.TO, InternetAddress(RECIPIENT_EMAIL))
                subject = "Checklist Paranalog - ID: $checklistId"

                // Create multipart message
                val multipart = MimeMultipart()

                // Body part
                val messageBodyPart = MimeBodyPart().apply {
                    setText("Segue em anexo o checklist de inspeção gerado pelo aplicativo Paranalog.")
                }
                multipart.addBodyPart(messageBodyPart)

                // Attachment part
                val attachmentBodyPart = MimeBodyPart().apply {
                    attachFile(pdfFile)
                    fileName = pdfFile.name // Set the filename for the attachment
                }
                multipart.addBodyPart(attachmentBodyPart)

                // Set the multipart content
                setContent(multipart)
            }

            // Send the email
            Log.d(TAG, "Attempting to send email for checklist ID: $checklistId")
            Transport.send(message)
            Log.i(TAG, "Email sent successfully for checklist ID: $checklistId")

            // Update status to sent
            updateStatus(checklistId, "email_sent")
            return@withContext Result.success()

        } catch (e: MessagingException) {
            Log.e(TAG, "Error sending email for checklist ID: $checklistId", e)
            updateStatus(checklistId, "email_error")
            // Retry might be appropriate depending on the error (e.g., temporary network issue)
            return@withContext Result.retry()
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error during email sending for checklist ID: $checklistId", e)
            updateStatus(checklistId, "email_error")
            return@withContext Result.failure()
        }
    }

    private suspend fun updateStatus(checklistId: Long, newStatus: String) {
        try {
            val database = AppDatabase.getDatabase(applicationContext)
            val checklistDao = database.checklistDao()
            checklistDao.updateStatus(checklistId, newStatus)
            Log.d(TAG, "Updated status for checklist $checklistId to $newStatus")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update status for checklist $checklistId", e)
        }
    }
}

