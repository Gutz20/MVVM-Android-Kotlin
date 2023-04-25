package com.optic.paqta.domain.model

import com.google.gson.Gson

data class Member(
    var id: String = "",
    var name: String = "",
    var lastName: String = "",
    var phone: String = "",
) {
    fun toJson(): String = Gson().toJson(
        User(
            id,
            name,
            lastName,
            phone,
            phone,
        )
    )

    companion object {
        fun fromJson(data: String): Member = Gson().fromJson(data, Member::class.java)

    }
}