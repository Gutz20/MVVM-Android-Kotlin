package com.optic.paqta.presentation.screens.new_backpack

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.screens.backpack.components.BackpackContent

@Composable
fun NewBackpackScreen(navController: NavHostController) {
    Scaffold(
        topBar = {},
        content = {
            BackpackContent(navController)
        },
        bottomBar = {}
    )
}