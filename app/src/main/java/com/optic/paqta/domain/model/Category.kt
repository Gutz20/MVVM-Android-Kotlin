package com.optic.paqta.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Category(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var image: String = "",
    var imagenDeReferencia: String = "",
    var items: ArrayList<String> = ArrayList()
) {

    fun toJson(): String = Gson().toJson(Category(
        id,
        name,
        description,
        if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
        if (imagenDeReferencia != "") URLEncoder.encode(imagenDeReferencia, StandardCharsets.UTF_8.toString()) else "",
        items
    ))

    companion object {
        fun fromJson(data: String): Category = Gson().fromJson(data, Category::class.java)
    }

}