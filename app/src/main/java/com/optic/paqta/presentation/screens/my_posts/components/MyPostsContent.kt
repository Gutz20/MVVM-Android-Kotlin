package com.optic.paqta.presentation.screens.my_posts.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.optic.paqta.domain.model.Post
import com.optic.paqta.presentation.screens.my_posts.components.MyPostsCard

@Composable
fun MyPostsContent(
    navController: NavHostController,
    posts: List<Post>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = posts
        ) { post ->
             MyPostsCard(navController, post = post)
        }
    }
}