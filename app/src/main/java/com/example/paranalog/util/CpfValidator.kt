package com.example.paranalog.util

object CpfValidator {

    fun isValid(cpf: String?): Boolean {
        if (cpf == null) return false

        val cleanedCpf = cpf.replace("[.\\-]".toRegex(), "")

        // Basic checks: size and all same digits
        if (cleanedCpf.length != 11 || cleanedCpf.all { it == cleanedCpf[0] }) {
            return false
        }

        try {
            val d1 = calculateDigit(cleanedCpf.substring(0, 9), 10)
            val d2 = calculateDigit(cleanedCpf.substring(0, 9) + d1, 11)

            return cleanedCpf == cleanedCpf.substring(0, 9) + d1 + d2
        } catch (e: NumberFormatException) {
            return false
        }
    }

    private fun calculateDigit(str: String, weight: Int): Int {
        var sum = 0
        var currentWeight = weight
        for (i in str.indices) {
            sum += str[i].toString().toInt() * currentWeight--
        }
        val remainder = sum % 11
        return if (remainder < 2) 0 else 11 - remainder
    }

    // Optional: Format CPF to standard xxx.xxx.xxx-xx
    fun formatCpf(cpf: String): String {
        val cleanedCpf = cpf.replace("[.\\-]".toRegex(), "")
        return if (cleanedCpf.length == 11) {
            cleanedCpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})".toRegex(), "$1.$2.$3-$4")
        } else {
            cpf // Return original if not 11 digits
        }
    }

    // Optional: Clean CPF (remove formatting)
    fun cleanCpf(cpf: String): String {
        return cpf.replace("[.\\-]".toRegex(), "")
    }
}

