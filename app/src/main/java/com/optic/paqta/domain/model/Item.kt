package com.optic.paqta.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Item (
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var category: String = "",
    var image: String = "",
) {
    fun toJson(): String = Gson().toJson(Post(
        id,
        name,
        description,
        category,
        if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
    ))

    companion object {
        fun fromJson(data: String): Item = Gson().fromJson(data, Item::class.java)
    }
}