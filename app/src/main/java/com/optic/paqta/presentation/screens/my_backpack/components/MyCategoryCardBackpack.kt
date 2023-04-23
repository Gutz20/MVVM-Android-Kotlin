package com.optic.paqta.presentation.screens.my_backpack.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import com.optic.paqta.domain.model.Category
import com.optic.paqta.presentation.navigation.DetailsScreen
import com.optic.paqta.presentation.screens.my_backpack.MyBackpacksViewModel


@Composable
fun MyCategoryCardBackpack(
    navController: NavHostController,
    viewModel: MyBackpacksViewModel = hiltViewModel(),
    category: Category,
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .clickable {
                navController.navigate(route = DetailsScreen.DetailCategory.passCategory(category.toJson()))
            },
        elevation = 4.dp,
        contentColor = Color.White,
    ) {
        Column(
            modifier = Modifier.padding(bottom = 5.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = category.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = category.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 3.dp, bottom = 3.dp),
                text = category.description,
                fontSize = 13.sp,
                maxLines = 2,
                color = Color.Gray
            )
        }
    }
}