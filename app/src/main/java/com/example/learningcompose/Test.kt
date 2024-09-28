package com.example.learningcompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


data class ValidationState (
    val userName: String = "",
    val password: String = "",
    val email: String = "",
    val userNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null
)

class FormViewModel : ViewModel() {
    private val _state = MutableStateFlow(ValidationState())
    val state: StateFlow<ValidationState> = _state


    fun updateUserName(userName: String) {
        _state.value = _state.value.copy(userName = userName)
    }

    fun updateEmail(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun updatePassword(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun validate() {
        val currentState = _state.value
        val userNameError = if (currentState.userName.isEmpty()) "Username cannot be empty" else null
        val emailError = if (currentState.email.isEmpty()) "Email cannot be empty" else null
        val passwordError = if (currentState.password.isEmpty()) "Password cannot be empty" else null

        _state.value = currentState.copy(
            userNameError = userNameError,
            emailError = emailError,
            passwordError = passwordError
        )
    }
}




//    private val _email = MutableStateFlow("")
//    val email: StateFlow<String> = _email
//
//    private val _password = MutableStateFlow("")
//    val password: StateFlow<String> = _password
//
//    private val _isEmailValid = MutableStateFlow(true)
//    val isEmailValid: StateFlow<Boolean> = _isEmailValid
//
//    private val _isPasswordValid = MutableStateFlow(true)
//    val isPasswordValid: StateFlow<Boolean> = _isPasswordValid
//
//    private val _isFormValid = MutableStateFlow(false)
//    val isFormValid: StateFlow<Boolean> = _isFormValid

//    fun onEmailChange(newEmail: String) {
//        _email.value = newEmail
//        _isEmailValid.value = android.util.Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()
//        validateForm()
//    }
//
//    fun onPasswordChange(newPassword: String) {
//        _password.value = newPassword
//        _isPasswordValid.value = newPassword.length >= 8
//        validateForm()
//    }
//
//    private fun validateForm() {
//        _isFormValid.value = _isEmailValid.value && _isPasswordValid.value
//    }
//}
