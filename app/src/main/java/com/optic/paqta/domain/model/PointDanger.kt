package com.optic.paqta.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class PointDanger(
    var id: String = "",
    var category: String = "",
    var description: String = "",
    var idUser: String = "",
    var user: User? = null,
) {
    fun toJson(): String = Gson().toJson(
        PointDanger(
            id,
            category,
            description,
            idUser,
            User(
                id = user?.id ?: "",
                username = user?.username ?: "",
                email = user?.email ?: "",
                image =
                if (!user?.image.isNullOrBlank())
                    URLEncoder.encode(user?.image, StandardCharsets.UTF_8.toString())
                else "",
            )
        )
    )

    companion object {
        fun fromJson(data: String): PointDanger = Gson().fromJson(data, PointDanger::class.java)
    }
}