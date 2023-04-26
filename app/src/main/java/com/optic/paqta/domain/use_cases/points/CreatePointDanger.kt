package com.optic.paqta.domain.use_cases.points

import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.model.PointDanger
import com.optic.paqta.domain.repository.PointsDangerRepository
import java.io.File
import javax.inject.Inject

class CreatePointDanger @Inject constructor(private val repository: PointsDangerRepository) {
    suspend operator fun invoke(pointDanger: PointDanger) = repository.create(pointDanger)
}
