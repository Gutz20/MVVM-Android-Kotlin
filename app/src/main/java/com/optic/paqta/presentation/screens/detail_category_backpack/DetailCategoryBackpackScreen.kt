package com.optic.paqta.presentation.screens.detail_category_backpack

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.screens.detail_category_backpack.components.DetailCategoryBakpackContent
import com.optic.paqta.presentation.screens.detail_post.components.DetailPostContent

@Composable
fun DetailCategoryBakpackScreen(navController: NavHostController, category: String) {
    Scaffold(
        content = {
            DetailCategoryBakpackContent(navController)
        }
    )
}