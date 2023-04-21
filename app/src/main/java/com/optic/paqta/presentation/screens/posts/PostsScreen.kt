package com.optic.paqta.presentation.screens.posts

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.screens.posts.components.DeleteLikePost
import com.optic.paqta.presentation.screens.posts.components.GetPosts
import com.optic.paqta.presentation.screens.posts.components.LikePost

@Composable
fun PostsScreen(navController: NavHostController, viewModel: PostsViewModel = hiltViewModel()) {
    
    Scaffold(
        content = {
            GetPosts(navController)
        }
    )
    LikePost()
    DeleteLikePost()
    
}