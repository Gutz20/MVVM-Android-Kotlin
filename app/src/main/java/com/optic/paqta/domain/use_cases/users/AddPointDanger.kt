package com.optic.paqta.domain.use_cases.users

import com.optic.paqta.domain.model.PointDanger
import com.optic.paqta.domain.repository.UsersRepository
import javax.inject.Inject

class AddPointDanger @Inject constructor(private val repository: UsersRepository) {

    suspend operator fun invoke(idUser: String, datos: ArrayList<PointDanger>) = repository.addPointDanger(idUser, datos)
}