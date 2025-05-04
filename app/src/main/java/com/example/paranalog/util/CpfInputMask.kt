package com.example.paranalog.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * TextWatcher to automatically format CPF input as ###.###.###-##.
 * Uses a safer approach to avoid infinite loops.
 */
class CpfInputMask(private val editText: EditText) : TextWatcher {

    private var isUpdating: Boolean = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        if (isUpdating) {
            return
        }

        isUpdating = true

        val originalText = s.toString()
        val digitsOnly = originalText.replace("[^\\d]".toRegex(), "")

        val formattedText = formatCpf(digitsOnly)

        // Only update if the formatted text is different from the current text
        if (originalText != formattedText) {
            editText.setText(formattedText)
            // Try to set cursor position at the end, consider edge cases if needed
            try {
                editText.setSelection(formattedText.length)
            } catch (e: Exception) {
                // Ignore potential index errors during rapid typing/deleting
            }
        }

        isUpdating = false
    }

    companion object {
        fun formatCpf(cpf: String): String {
            val digitsOnly = cpf.replace("[^\\d]".toRegex(), "")
            val builder = StringBuilder()
            var i = 0
            for (char in digitsOnly) {
                if (i == 3 || i == 6) {
                    builder.append('.')
                }
                if (i == 9) {
                    builder.append('-')
                }
                if (i < 11) { // Limit to 11 digits
                    builder.append(char)
                    i++
                } else {
                    break // Stop if more than 11 digits are entered
                }
            }
            return builder.toString()
        }

        fun cleanCpf(cpf: String): String {
            return cpf.replace("[^\\d]".toRegex(), "")
        }
    }
}

