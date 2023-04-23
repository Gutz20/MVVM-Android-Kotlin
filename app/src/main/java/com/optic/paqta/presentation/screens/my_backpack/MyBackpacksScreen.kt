package com.optic.paqta.presentation.screens.my_backpack

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.components.DefaultModalDrawer
import com.optic.paqta.presentation.components.DefaultTopBar
import com.optic.paqta.presentation.navigation.DetailsScreen
import com.optic.paqta.presentation.screens.my_backpack.components.GetBackpacksByIdUser
import com.optic.paqta.presentation.screens.my_backpack.components.GetCategories
import com.optic.paqta.presentation.screens.my_backpack.components.MyBackpacksContent
import com.optic.paqta.presentation.screens.my_posts.components.GetPostsByIdUser

@Composable
fun MyBackpacksScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(title = "Mi Mochila")
        },
        content = {
            GetCategories(navController)
        },
//        floatingActionButton = {
//            FloatingActionButton(
//                modifier = Modifier.padding(bottom = 50.dp),
//                onClick = { navController.navigate(DetailsScreen.NewBackpack.route) }
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = ""
//                )
//            }
//        }
    )

}