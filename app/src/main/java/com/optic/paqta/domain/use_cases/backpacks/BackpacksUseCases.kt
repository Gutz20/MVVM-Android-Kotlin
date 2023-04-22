package com.optic.paqta.domain.use_cases.backpacks

data class BackpacksUseCases(
    val create: CreateBackpack,
    val getBackpacks: GetBackpacks,
    val getBackpacksByIdUser: GetBackpacksByIdUser,
    val deleteBackpack: DeleteBackpack,
    val updateBackpack: UpdateBackpack,
    val addItemBackpack: AddItemBackpack,
    val deleteItemBackpack: DeleteItemBackpack
)