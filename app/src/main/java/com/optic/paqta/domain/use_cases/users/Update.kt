package com.optic.paqta.domain.use_cases.users

import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository) {

    suspend operator fun invoke(user: User) = repository.update(user)

}