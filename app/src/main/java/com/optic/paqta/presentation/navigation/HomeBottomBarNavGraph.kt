package com.optic.paqta.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.optic.paqta.presentation.screens.my_backpack.MyBackpacksScreen
import com.optic.paqta.presentation.screens.posts.PostsScreen
import com.optic.paqta.presentation.screens.profile.ProfileScreen
import com.optic.paqta.presentation.screens.ubication.UbicationScreen

@Composable
fun HomeBottomBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Posts.route
    ) {

        composable(route = HomeBottomBarScreen.Posts.route) {
            PostsScreen(navController)
        }

        composable(route = HomeBottomBarScreen.Ubication.route) {
            UbicationScreen(navController)
        }

        composable(route = HomeBottomBarScreen.Backpacks.route) {
            MyBackpacksScreen(navController)
        }

        composable(route = HomeBottomBarScreen.Profile.route) {
            ProfileScreen(navController)
        }

        detailsNavGraph(navController)

    }

}


sealed class HomeBottomBarScreen(
    val route: String,
    var title: String,
    val icon: ImageVector
) {

    object Posts: HomeBottomBarScreen(
        route = "posts",
        title = "Tips",
        icon = Icons.Default.List
    )

    object Ubication: HomeBottomBarScreen(
        route = "ubication",
        title = "Mapa",
        icon = Icons.Outlined.Place
    )

    object Backpacks: HomeBottomBarScreen(
        route = "backpacks",
        title = "Mochila",
        icon = Icons.Outlined.Email
    )

    object Profile: HomeBottomBarScreen(
        route = "profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}