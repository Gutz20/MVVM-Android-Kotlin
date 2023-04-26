package com.optic.paqta.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Member(
    var id: String = "",
    var name: String = "",
    var lastName: String = "",
    var phone: String = "",
    var movilityDifficulty: String = "",
    var idUser: String = "",
    var image: String = "",
    var user: User? = null,
) {
    fun toJson(): String = Gson().toJson(
        Member(
            id,
            name,
            lastName,
            phone,
            movilityDifficulty,
            idUser,
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
            User(
                id = user?.id ?: "",
                username = user?.username ?: "",
                email = user?.email ?: "",
                image =
                if (!user?.image.isNullOrBlank())
                    URLEncoder.encode(user?.image, StandardCharsets.UTF_8.toString())
                else "",
            ),
        )
    )

    companion object {
        fun fromJson(data: String): Member = Gson().fromJson(data, Member::class.java)

    }
}