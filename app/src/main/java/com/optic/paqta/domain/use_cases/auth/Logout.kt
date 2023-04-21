package com.optic.paqta.domain.use_cases.auth

import com.optic.paqta.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.logout()

}