package com.optic.paqta.presentation.screens.profile

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.use_cases.auth.AuthUseCases
import com.optic.paqta.domain.use_cases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val usersUsersUseCases: UsersUseCases
) : ViewModel() {

    var userData by mutableStateOf(User())
        private set
    val currentUser = authUseCases.getCurrentUser()

    init {
        getUserById()
    }

    private fun getUserById() = viewModelScope.launch {
        usersUsersUseCases.getUserById(currentUser!!.uid).collect() {
            userData = it
        }
    }

    fun logout() {
        authUseCases.logout()
    }

}