package com.optic.paqta.presentation.screens.detail_post

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.navigation.DetailsScreen
import com.optic.paqta.presentation.screens.detail_post.components.DetailPostContent

@Composable
fun DetailPostScreen(navController: NavHostController, post: String) {
    Scaffold(
        content = {
            DetailPostContent(navController)
        }
    )
}