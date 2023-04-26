package com.optic.paqta.presentation.screens.my_croquis

import com.optic.paqta.domain.model.PointDanger

data class NewCroquisState (
    val imageMapping: String = "",
    val pointsOfDanger: ArrayList<PointDanger> = ArrayList()
)