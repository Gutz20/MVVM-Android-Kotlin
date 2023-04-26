package com.optic.paqta.domain.use_cases.points

import com.optic.paqta.domain.repository.PointsDangerRepository
import javax.inject.Inject

class GetPointsByIdUser @Inject constructor(private val repository: PointsDangerRepository) {

    operator fun invoke(idUser: String) = repository.getPointsByUserId(idUser)
}