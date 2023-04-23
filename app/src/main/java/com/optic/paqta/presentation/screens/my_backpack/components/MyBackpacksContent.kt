package com.optic.paqta.presentation.screens.my_backpack.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.optic.paqta.R
import com.optic.paqta.domain.model.Backpack
import com.optic.paqta.domain.model.Category
import com.optic.paqta.domain.model.Post
import com.optic.paqta.presentation.components.DefaultModalDrawer

@Composable
fun MyBackpacksContent(
    navController: NavHostController,
    backpacks: List<Backpack> = ArrayList(),
    categories: List<Category> = ArrayList()
) {

    Column(
        modifier = Modifier.padding(top = 10.dp, bottom = 55.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.backpack_color),
                contentDescription = "Mochila",
                contentScale = ContentScale.Crop,
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
            ) {
                Log.d("categoriasss", "Esto: $categories")
                items (
                    items = categories
                ) {category ->
                    MyCategoryCardBackpack(navController = navController, category = category)
                }
            }
        }
    }
}