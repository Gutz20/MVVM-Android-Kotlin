package com.optic.paqta.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.optic.paqta.presentation.screens.home.HomeScreen
import com.optic.paqta.presentation.screens.login.LoginScreen
import com.optic.paqta.presentation.screens.profile.ProfileScreen
import com.optic.paqta.presentation.screens.profile_update.ProfileUpdateScreen
import com.optic.paqta.presentation.screens.signup.SignupScreen

@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {

        authNavGraph(navController = navController)
        composable(route = Graph.HOME) {
            HomeScreen()
        }

    }

}
