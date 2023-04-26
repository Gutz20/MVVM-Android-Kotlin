package com.optic.paqta.domain.use_cases.members

import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.repository.MembersRepository
import java.io.File
import javax.inject.Inject

class CreateMember @Inject constructor(private val repository: MembersRepository) {

    suspend operator fun invoke(member: Member, file: File) = repository.create(member, file)
}