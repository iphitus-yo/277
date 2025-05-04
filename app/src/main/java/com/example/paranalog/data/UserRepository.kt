package com.example.paranalog.data

import com.example.paranalog.util.CpfValidator // Import CpfValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.MessageDigest

// Repository for handling User data operations
class UserRepository(private val userDao: UserDao) {

    // Function to find a user by CPF (runs on IO dispatcher)
    suspend fun findUserByCpf(cpf: String): User? {
        // Expects cleaned CPF from ViewModel
        return withContext(Dispatchers.IO) {
            userDao.getUserByCpf(cpf)
        }
    }

    // Function to find a user by ID (runs on IO dispatcher)
    suspend fun getUserById(id: Long): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUserById(id)
        }
    }

    // Function to register a new user (runs on IO dispatcher)
    // Takes plain password, hashes it, then inserts
    suspend fun registerUser(name: String, cpfInput: String, plainPassword: String, plateCavalo: String?, plateCarreta: String?): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                // *** Clean the CPF before using it ***
                val cleanedCpf = CpfValidator.cleanCpf(cpfInput)

                // Basic validation (more robust validation should be in ViewModel/UI)
                if (name.isBlank() || cleanedCpf.isBlank() || plainPassword.isBlank()) {
                    return@withContext Result.failure(IllegalArgumentException("Nome, CPF e senha são obrigatórios."))
                }
                // Check if user already exists using the cleaned CPF
                if (userDao.getUserByCpf(cleanedCpf) != null) {
                    return@withContext Result.failure(IllegalArgumentException("CPF já cadastrado."))
                }

                // Hash the password before storing
                val passwordHash = hashPassword(plainPassword)

                // *** Save the cleaned CPF ***
                val newUser = User(
                    name = name,
                    cpf = cleanedCpf, // Use cleaned CPF
                    passwordHash = passwordHash,
                    defaultPlateCavalo = plateCavalo,
                    defaultPlateCarreta = plateCarreta
                )
                userDao.insert(newUser)
                Result.success(Unit)
            } catch (e: Exception) {
                // Catch potential database errors (like unique constraint violation if index fails)
                Result.failure(e)
            }
        }
    }

    // Simple password hashing function (replace with a stronger library like bcrypt in production)
    private fun hashPassword(password: String): String {
        val bytes = password.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }

    // Function to verify password (runs on IO dispatcher)
    suspend fun verifyPassword(user: User, plainPassword: String): Boolean {
        return withContext(Dispatchers.IO) {
            val inputHash = hashPassword(plainPassword)
            inputHash == user.passwordHash
        }
    }
}

