package com.example.paranalog.worker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface // Import Typeface
import android.graphics.pdf.PdfDocument
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.paranalog.data.AppDatabase
import com.example.paranalog.data.Checklist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NativePdfGenerationWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    companion object {
        const val KEY_CHECKLIST_ID = "checklist_id"
        const val KEY_PDF_PATH = "pdf_path" // Output the file path
        private const val TAG = "NativePdfWorker"

        // PDF Layout Constants
        private const val PAGE_WIDTH = 595 // A4 width in points (approx)
        private const val PAGE_HEIGHT = 842 // A4 height in points (approx)
        private const val MARGIN = 40
        private const val CONTENT_WIDTH = PAGE_WIDTH - 2 * MARGIN
        private const val LINE_SPACING = 5f
        private const val SECTION_SPACING = 15f
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

        // Define output PDF path
        val outputDir = File(applicationContext.filesDir, "pdfs")
        if (!outputDir.exists()) {
            outputDir.mkdirs()
        }
        val timestampStr = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date(checklist.timestamp))
        val pdfFileName = "checklist_${checklistId}_${timestampStr}.pdf"
        val outputFile = File(outputDir, pdfFileName)

        val document = PdfDocument()
        var currentPageNumber = 1
        var pageInfo = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, currentPageNumber).create()
        var page = document.startPage(pageInfo)
        var canvas = page.canvas
        var yPosition = MARGIN.toFloat()

        val titlePaint = TextPaint().apply {
            color = Color.BLACK
            textSize = 16f
            isFakeBoldText = true
        }
        val labelPaint = TextPaint().apply {
            color = Color.BLACK
            textSize = 10f
            isFakeBoldText = true
        }
        val textPaint = TextPaint().apply {
            color = Color.BLACK
            textSize = 10f
        }
        // Corrected: Removed isItalic, using Typeface for style
        val commentPaint = TextPaint().apply {
            color = Color.DKGRAY
            textSize = 9f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
        }

        try {
            // --- Draw Header ---
            yPosition = drawText(canvas, "CHECKLIST DE INSPEÇÃO DE VEÍCULO", titlePaint, MARGIN.toFloat(), yPosition, CONTENT_WIDTH)
            yPosition += SECTION_SPACING

            yPosition = drawLabelAndValue(canvas, "Local Coleta:", checklist.localColeta, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Responsável:", checklist.responsavel, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Data/Hora Início:", checklist.data, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Placa Cavalo:", checklist.placaCavalo, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Placa Carreta:", checklist.placaCarreta, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Motorista:", checklist.motorista, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "DI/DUE/CRT/MIC/DTA:", checklist.diDueCrtMicDta, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "NF-e:", checklist.nfE, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Lacre Entrada:", checklist.lacreEntrada, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Lacre Saída:", checklist.lacreSaida, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Peso Bruto:", checklist.pesoBruto, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Tipo Viagem:", checklist.tipoViagem, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition += SECTION_SPACING

            // --- Draw Inspection Items ---
            yPosition = drawInspectionItem(canvas, "1. Pára-choque Dianteiro", checklist.item1_parachoque, checklist.item1_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "2. Motor", checklist.item2_motor, checklist.item2_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "3. Pneus", checklist.item3_pneus, checklist.item3_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "4. Unidade Tratora", checklist.item4_unidadeTratora, checklist.item4_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "5. Tanques de Combustível", checklist.item5_tanquesCombustivel, checklist.item5_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "6. Cabine", checklist.item6_cabine, checklist.item6_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "7. Eixo Elevatório de Ar", checklist.item7_eixoElevatorioAr, checklist.item7_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "8. Eixo de Transmissão", checklist.item8_eixoTransmissao, checklist.item8_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "9. Área da Quinta Roda", checklist.item9_areaQuintaRoda, checklist.item9_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "10. Sistema de Exaustão", checklist.item10_sistemaExaustao, checklist.item10_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "11. Chassi", checklist.item11_chassi, checklist.item11_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "12. Portas Traseiras", checklist.item12_portasTraseira, checklist.item12_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "13. Porta Lateral Direita", checklist.item13_portaLateralDireita, checklist.item13_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "14. Porta Lateral Esquerda", checklist.item14_portaLateralEsquerda, checklist.item14_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "15. Parede Frontal", checklist.item15_paredeFrontal, checklist.item15_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "16. Teto", checklist.item16_teto, checklist.item16_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "17. Piso do Comp. de Carga", checklist.item17_pisoCompartimentoCarga, checklist.item17_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "18. Dutos de Ar", checklist.item18_dutosAr, checklist.item18_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawInspectionItem(canvas, "19. Motor Câmara Fria", checklist.item19_motorCamaraFria, checklist.item19_comentario, labelPaint, textPaint, commentPaint, MARGIN.toFloat(), yPosition)

            yPosition += SECTION_SPACING

            // --- Draw Additional Checks ---
            yPosition = drawLabelAndValue(canvas, "Odores Estranhos:", checklist.odores, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawComment(canvas, checklist.odores_comentario, commentPaint, MARGIN.toFloat() + 10, yPosition)
            yPosition = drawLabelAndValue(canvas, "Pragas Visíveis:", checklist.pragasVisiveis, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawComment(canvas, checklist.pragas_comentario, commentPaint, MARGIN.toFloat() + 10, yPosition)
            yPosition = drawLabelAndValue(canvas, "Contaminação Química:", checklist.contaminacaoQuimica, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawComment(canvas, checklist.contaminacao_comentario, commentPaint, MARGIN.toFloat() + 10, yPosition)
            yPosition = drawLabelAndValue(canvas, "Fundo/Parede Falsa:", checklist.fundoParedeFalsa, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawComment(canvas, checklist.fundoParede_comentario, commentPaint, MARGIN.toFloat() + 10, yPosition)
            yPosition = drawLabelAndValue(canvas, "Indícios de Contaminação:", checklist.indiciosContaminacao, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawComment(canvas, checklist.indicios_comentario, commentPaint, MARGIN.toFloat() + 10, yPosition)

            yPosition += SECTION_SPACING

            // --- Draw Item em Desacordo & Autoridade ---
            yPosition = drawLabelAndValue(canvas, "Item em Desacordo:", if (checklist.itemEmDesacordo) "Sim" else "Não", labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            // TODO: Add logic to draw the photo if checklist.fotoItemDesacordoPath is not null

            yPosition = drawLabelAndValue(canvas, "Autoridade Notificada:", if (checklist.autoridadeNotificada == true) "Sim" else "Não", labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            if (checklist.autoridadeNotificada == true) {
                yPosition = drawLabelAndValue(canvas, "Data/Hora Notificação:", checklist.dataHoraNotificacao, labelPaint, textPaint, MARGIN.toFloat() + 10, yPosition)
                yPosition = drawComment(canvas, checklist.autoridade_comentario, commentPaint, MARGIN.toFloat() + 10, yPosition)
            }

            yPosition += SECTION_SPACING

            // --- Draw Footer ---
            yPosition = drawLabelAndValue(canvas, "Data/Hora Término:", checklist.dataHoraTermino, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Assinatura Vistoriador:", checklist.assinaturaVistoriador, labelPaint, textPaint, MARGIN.toFloat(), yPosition)
            yPosition = drawLabelAndValue(canvas, "Assinatura Motorista:", checklist.assinaturaMotorista, labelPaint, textPaint, MARGIN.toFloat(), yPosition)

            // Finish the page
            document.finishPage(page)

            // --- Write PDF to file ---
            FileOutputStream(outputFile).use {
                document.writeTo(it)
            }
            document.close()

            Log.i(TAG, "PDF generated successfully at: ${outputFile.absolutePath}")

            // Update checklist status and PDF path in DB
            val updatedChecklist = checklist.copy(pdfPath = outputFile.absolutePath, status = "pdf_generated") // New status
            checklistDao.update(updatedChecklist)

            // Pass the PDF path to the next worker
            val outputData = workDataOf(KEY_PDF_PATH to outputFile.absolutePath)
            return@withContext Result.success(outputData)

        } catch (e: IOException) {
            Log.e(TAG, "Error writing PDF", e)
            val updatedChecklist = checklist.copy(status = "pdf_error")
            checklistDao.update(updatedChecklist)
            return@withContext Result.failure()
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error during PDF generation", e)
            val updatedChecklist = checklist.copy(status = "pdf_error")
            checklistDao.update(updatedChecklist)
            return@withContext Result.failure()
        } finally {
            // Ensure document is closed even if errors occur before writing
            // Note: This might cause issues if finishPage wasn't called.
            // Consider more robust error handling if needed.
            // document.close() // Already closed in the happy path
        }
    }

    // Helper function to draw text and handle line breaks
    private fun drawText(canvas: Canvas, text: String, paint: TextPaint, x: Float, y: Float, width: Int): Float {
        val staticLayout = StaticLayout.Builder.obtain(text, 0, text.length, paint, width)
            .setAlignment(Layout.Alignment.ALIGN_NORMAL)
            .setLineSpacing(0f, 1.0f)
            .setIncludePad(false)
            .build()

        canvas.save()
        canvas.translate(x, y)
        staticLayout.draw(canvas)
        canvas.restore()

        return y + staticLayout.height + LINE_SPACING
    }

    // Helper function to draw a label and its value
    private fun drawLabelAndValue(canvas: Canvas, label: String, value: String?, labelPaint: TextPaint, valuePaint: TextPaint, x: Float, y: Float): Float {
        val displayValue = value ?: "-"
        val labelWidth = labelPaint.measureText(label)
        // Draw label first
        drawText(canvas, label, labelPaint, x, y, CONTENT_WIDTH)
        // Draw value next to the label on the same line (adjust x position)
        val valueY = drawText(canvas, displayValue, valuePaint, x + labelWidth + 5, y, CONTENT_WIDTH - labelWidth.toInt() - 5)
        // Return the Y position after drawing the value (which determines the line height)
        return valueY
    }

    // Helper function to draw an inspection item (label, value, comment)
    private fun drawInspectionItem(canvas: Canvas, label: String, value: String?, comment: String?, labelPaint: TextPaint, valuePaint: TextPaint, commentPaint: TextPaint, x: Float, y: Float): Float {
        var currentY = drawLabelAndValue(canvas, label, value, labelPaint, valuePaint, x, y)
        if (!comment.isNullOrBlank()) {
            currentY = drawComment(canvas, comment, commentPaint, x + 10, currentY)
        }
        return currentY
    }

    // Helper function to draw comments
    private fun drawComment(canvas: Canvas, comment: String?, paint: TextPaint, x: Float, y: Float): Float {
        if (comment.isNullOrBlank()) return y
        return drawText(canvas, "Comentário: $comment", paint, x, y, CONTENT_WIDTH - 10)
    }
}

