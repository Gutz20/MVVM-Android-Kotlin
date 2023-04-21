package com.optic.paqta.presentation.screens.my_posts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.screens.my_posts.components.GetPostsByIdUser
import com.optic.paqta.presentation.navigation.DetailsScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyPostsScreen(navController: NavHostController) {

    Scaffold(
        content = {
            GetPostsByIdUser(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = { navController.navigate(DetailsScreen.NewPost.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    )
} 