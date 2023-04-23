package com.optic.paqta.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.optic.paqta.presentation.screens.my_backpack.MyBackpacksScreen
import com.optic.paqta.presentation.screens.profile.ProfileScreen

@Composable
fun ModalDrawerBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.MENU,
        startDestination = ModalDraverBarScreen.Backpacks.route
    ) {
        composable(route = ModalDraverBarScreen.Backpacks.route) {
            MyBackpacksScreen(navController)
        }

        composable(route = ModalDraverBarScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }

}

sealed class ModalDraverBarScreen(
    val route: String,
    var title: String,
    val icon: ImageVector
) {

    object Backpacks : HomeBottomBarScreen(
        route = "backpacks",
        title = "Mochila",
        icon = Icons.Outlined.Home
    )

    object Profile : HomeBottomBarScreen(
        route = "profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}