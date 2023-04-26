package com.optic.paqta.domain.use_cases.points

data class PointsUseCases (
    val createPointDanger: CreatePointDanger,
    val saveImage: SaveImagePointDanger,
    val getPointsByIdUser: GetPointsByIdUser
)