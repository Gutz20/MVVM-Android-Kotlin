package com.optic.paqta.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import com.optic.paqta.domain.use_cases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCases: AuthUseCases, private val usersUserCases: UsersUseCases): ViewModel()  {

//    STATE FORM
    var state by mutableStateOf(SignupState())
        private set

    //    USERNAME
    var isUsernameValid by mutableStateOf(false)
        private set
    var usernameErrMessage by mutableStateOf("")
        private set

    //    EMAIL
    var isEmailValid by mutableStateOf(false)
        private set
    var emailErrorMessage by mutableStateOf("")
        private set

    //    PASSWORD
    var isPasswordValid by mutableStateOf(false)
        private set
    var passwordErrorMessage by mutableStateOf("")
        private set

    //    CONFIRMAR CONTRASENA
    var isConfirmPassword by mutableStateOf(false)
        private set
    var confirmPasswordErrMsg by mutableStateOf("")
        private set

    // Enable Button
    var isEnabledLoginButton = false

    var signupResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    val user = User()

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun onSignup() {
        user.username = state.username
        user.email = state.email
        user.password = state.password
        signup(user)
    }

    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getCurrentUser()!!.uid
        usersUserCases.create(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        signupResponse = Response.Loading
        val result = authUseCases.signup(user)
        signupResponse = result
    }

    fun enableLoginButton() {
        isEnabledLoginButton =
            isEmailValid &&
            isPasswordValid &&
            isUsernameValid &&
            isConfirmPassword
    }

    fun validateConfirmPassword() {
        if (state.password == state.confirmPassword) {
            isConfirmPassword = true
            confirmPasswordErrMsg = ""
        } else {
            isConfirmPassword = false
            confirmPasswordErrMsg = "Las contraseñas no coinciden"
        }
        enableLoginButton()
    }

    fun validateUsername() {
        if (state.username.length >= 5) {
            isUsernameValid = true
            usernameErrMessage = ""
        } else {
            isUsernameValid = false
            usernameErrMessage = "Al menos 5 caracteres"
        }

        enableLoginButton()
    }

    fun validateEmail() {
//        Es un email valido
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            isEmailValid = true
            emailErrorMessage = ""
        } else {
            isEmailValid = false
            emailErrorMessage = "El email no es valido"
        }

        enableLoginButton()
    }

    fun validatePassword() {
        if (state.password.length >= 6) {
            isPasswordValid = true
            passwordErrorMessage = ""
        } else {
            isPasswordValid = false
            passwordErrorMessage = "Al menos 6 caracteres"
        }

        enableLoginButton()
    }


}