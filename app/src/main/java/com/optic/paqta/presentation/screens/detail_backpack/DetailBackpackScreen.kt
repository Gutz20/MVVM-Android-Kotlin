package com.optic.paqta.presentation.screens.detail_backpack

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.screens.detail_backpack.components.DetailBackpackContent
import com.optic.paqta.presentation.screens.detail_post.components.DetailPostContent

@Composable
fun DetailBackpackScreen(navController: NavHostController, backpack: String) {
    Scaffold(
        content = {
            DetailBackpackContent(navController)
        }
    )
}