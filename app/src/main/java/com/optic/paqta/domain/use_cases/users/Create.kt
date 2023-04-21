package com.optic.paqta.domain.use_cases.users

import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.repository.UsersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UsersRepository) {

    suspend operator fun invoke(user: User) = repository.create(user)

}