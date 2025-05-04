package com.example.paranalog.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paranalog.data.UserRepository
import com.example.paranalog.util.CpfValidator // Assuming this utility class exists
import kotlinx.coroutines.launch

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    // LiveData for UI state and events
    private val _registrationResult = MutableLiveData<Result<Unit>>()
    val registrationResult: LiveData<Result<Unit>> = _registrationResult

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    // Function to handle registration attempt
    fun register(
        name: String,
        cpf: String, // Raw CPF from input
        pass: String,
        confirmPass: String,
        plateCavalo: String?,
        plateCarreta: String?
    ) {
        // Basic client-side validation
        if (name.isBlank() || cpf.isBlank() || pass.isBlank() || confirmPass.isBlank()) {
            _registrationResult.value = Result.failure(IllegalArgumentException("Todos os campos obrigatórios devem ser preenchidos."))
            return
        }
        // Validate CPF format before sending to repository
        if (!CpfValidator.isValid(cpf)) { // Use CPF validation utility
            _registrationResult.value = Result.failure(IllegalArgumentException("CPF inválido."))
            return
        }
        if (pass != confirmPass) {
            _registrationResult.value = Result.failure(IllegalArgumentException("As senhas não conferem."))
            return
        }
        // Consider adding password strength validation here

        _isLoading.value = true
        viewModelScope.launch {
            // *** Corrected parameter name: cpfInput = cpf ***
            val result = userRepository.registerUser(
                name = name.trim(),
                cpfInput = cpf, // Pass the raw CPF, repository will clean it
                plainPassword = pass,
                plateCavalo = plateCavalo?.trim()?.takeIf { it.isNotEmpty() },
                plateCarreta = plateCarreta?.trim()?.takeIf { it.isNotEmpty() }
            )
            _registrationResult.postValue(result)
            _isLoading.postValue(false)
        }
    }
}

