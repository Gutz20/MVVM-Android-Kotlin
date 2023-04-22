package com.optic.paqta.domain.model

import com.google.gson.Gson

data class Backpack (
    var id: String = "",
    var items: ArrayList<String> = ArrayList(),
) {

    companion object {
        fun fromJson(data: String): Backpack = Gson().fromJson(data, Backpack::class.java)
    }
}
