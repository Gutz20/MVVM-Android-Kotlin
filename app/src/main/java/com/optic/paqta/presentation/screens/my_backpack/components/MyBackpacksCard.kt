package com.optic.paqta.presentation.screens.my_backpack.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Post
import com.optic.paqta.presentation.navigation.DetailsScreen
import com.optic.paqta.presentation.screens.my_posts.MyPostsViewModel

@Composable
fun MyBackpacksCard(navController: NavHostController, backpack: Backpack, viewModel: MyPostsViewModel = hiltViewModel()) {

    Card(
        modifier = Modifier
            .padding(top = 0.dp, bottom = 15.dp)
            .clickable {
                navController.navigate(route = DetailsScreen.DetailBackpack.passBackpack(backpack.toJson()))
            },
        elevation = 4.dp,
        contentColor = Color.White,
    ) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = backpack.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                text = backpack.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 3.dp),
                text = backpack.description,
                fontSize = 13.sp,
                maxLines = 2,
                color = Color.Gray
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(route = DetailsScreen.UpdatePost.passPost(backpack.toJson()))
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Edit,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { viewModel.delete(backpack.id) }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

        }
    }

}