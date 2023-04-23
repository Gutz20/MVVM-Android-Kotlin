package com.optic.paqta.presentation.screens.sidebar

import androidx.compose.foundation.clickable
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.optic.paqta.presentation.navigation.ModalDraverBarScreen
import com.optic.paqta.presentation.navigation.ModalDrawerBarNavGraph
import androidx.compose.foundation.layout.RowScope
import com.optic.paqta.presentation.screens.home.AddItem


@Composable
fun SidebarScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        topBar = { SideBar(navController = navController) }
    ) {
        ModalDrawerBarNavGraph(navController = navController)
    }

}

@Composable
fun SideBar(navController: NavHostController) {
    val screens = listOf(
        ModalDraverBarScreen.Backpacks,
        ModalDraverBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val sideBarDestination = screens.any { it.route == currentDestination?.route }

    if (sideBarDestination) {

//        screens.forEach { screen ->
//            AddItem(
//                screen = screen,
//                currentDestination = currentDestination,
//                navController = navController
//            )
//        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RowScope.AddItem(
    screen: ModalDraverBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    ListItem(
        text = { Text(screen.title) },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = ""
            )
        },
        modifier = Modifier.clickable {

        }
    )

}