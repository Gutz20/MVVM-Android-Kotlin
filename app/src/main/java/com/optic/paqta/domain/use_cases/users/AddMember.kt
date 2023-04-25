package com.optic.paqta.domain.use_cases.users

import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.User
import com.optic.paqta.domain.repository.UsersRepository
import javax.inject.Inject

class AddMember @Inject constructor(private val repository: UsersRepository){

    suspend operator fun invoke(idUser: String, datos: ArrayList<Member>) = repository.addMember(idUser, datos);

}