package com.optic.paqta.domain.use_cases.points

import com.optic.paqta.domain.repository.PointsDangerRepository
import java.io.File
import javax.inject.Inject

class SaveImagePointDanger @Inject constructor(private val repository: PointsDangerRepository){
    suspend operator fun invoke(file: File) = repository.saveImage(file)
}