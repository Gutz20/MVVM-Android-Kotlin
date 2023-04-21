package com.optic.paqta.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.optic.paqta.domain.model.Response
import com.optic.paqta.domain.model.User

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>
    suspend fun signUp(user: User): Response<FirebaseUser>
    fun logout()
}