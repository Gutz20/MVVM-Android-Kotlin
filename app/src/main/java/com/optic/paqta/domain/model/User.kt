package com.optic.paqta.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    var id: String = "",
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var image: String = "",
    var phone: String = "",
    var imageMapping: String = "",
    var pointsOfDanger: ArrayList<PointDanger> = ArrayList(),
    var members: ArrayList<Member> = ArrayList()
) {
    fun toJson(): String = Gson().toJson(
        User(
            id,
            username,
            email,
            password,
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
            phone,
            if (imageMapping != "") URLEncoder.encode(
                imageMapping,
                StandardCharsets.UTF_8.toString()
            ) else "",
            pointsOfDanger,
            members
        )
    )

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }

}