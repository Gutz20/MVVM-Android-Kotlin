package com.optic.paqta.domain.use_cases.items

data class ItemsUseCases(
    val createItem: CreateItem,
    val deleteItem: DeleteItem,
    val updateItem: UpdateItem,
    val getItems: GetItems,
)