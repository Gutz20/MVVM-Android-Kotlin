package com.optic.paqta.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Backpack (
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var image: String = "",
    var idUser: String = "",
    var user: User? = null,
    var items: ArrayList<String> = ArrayList(),
) {
    fun toJson(): String = Gson().toJson(Backpack(
        id,
        name,
        description,
        if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
        idUser,
        User(
            id = user?.id ?: "",
            username = user?.username ?: "",
            email = user?.email ?: "",
            image = if (!user?.image.isNullOrBlank())
                URLEncoder.encode(user?.image, StandardCharsets.UTF_8.toString())
            else "",
        ),
        items,
    ))


    companion object {
        fun fromJson(data: String): Backpack = Gson().fromJson(data, Backpack::class.java)
    }
}
