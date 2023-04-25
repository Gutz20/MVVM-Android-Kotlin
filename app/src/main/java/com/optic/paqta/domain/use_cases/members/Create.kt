package com.optic.paqta.domain.use_cases.members

import com.optic.paqta.domain.model.Member
import com.optic.paqta.domain.repository.MembersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: MembersRepository) {

    suspend operator fun invoke(member: Member) = repository.create(member)

}