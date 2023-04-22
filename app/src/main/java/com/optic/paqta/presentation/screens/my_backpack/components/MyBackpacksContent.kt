package com.optic.paqta.presentation.screens.my_backpack.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Post

@Composable
fun MyBackpacksContent(
    navController: NavHostController,
    backpacks: List<Backpack>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = backpacks
        ) { backpack ->
            MyBackpacksCard(navController = navController, backpack = backpack)
        }
    }
}