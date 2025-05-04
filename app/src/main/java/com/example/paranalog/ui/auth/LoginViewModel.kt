package com.example.paranalog.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paranalog.data.User
import com.example.paranalog.data.UserRepository
import com.example.paranalog.util.CpfValidator
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    // LiveData for login result (Success with User or Failure)
    private val _loginResult = MutableLiveData<Result<User>>()
    val loginResult: LiveData<Result<User>> = _loginResult

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun login(cpf: String, pass: String) {
        // Basic client-side validation
        if (cpf.isBlank() || pass.isBlank()) {
            _loginResult.value = Result.failure(IllegalArgumentException("CPF e senha são obrigatórios."))
            return
        }
        if (!CpfValidator.isValid(cpf)) {
            _loginResult.value = Result.failure(IllegalArgumentException("CPF inválido."))
            return
        }

        _isLoading.value = true
        viewModelScope.launch {
            val cleanedCpf = CpfValidator.cleanCpf(cpf)
            val user = userRepository.findUserByCpf(cleanedCpf)

            if (user == null) {
                _loginResult.postValue(Result.failure(Exception("Usuário não encontrado.")))
            } else {
                val passwordMatches = userRepository.verifyPassword(user, pass)
                if (passwordMatches) {
                    _loginResult.postValue(Result.success(user))
                } else {
                    _loginResult.postValue(Result.failure(Exception("Senha incorreta.")))
                }
            }
            _isLoading.postValue(false)
        }
    }
}

