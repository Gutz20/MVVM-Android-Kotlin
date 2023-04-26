package com.optic.paqta.domain.use_cases.members

import com.optic.paqta.domain.repository.MembersRepository
import java.io.File
import javax.inject.Inject

class SaveImage @Inject constructor(private val repository: MembersRepository) {

    suspend operator fun invoke(file: File) = repository.saveImage(file)

}