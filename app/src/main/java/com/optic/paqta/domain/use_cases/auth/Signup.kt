package com.optic.paqta.domain.use_cases.auth

import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.signUp(user)

}