package com.optic.paqta.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.optic.paqta.presentation.ui.theme.Red500

@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null,
    otherIconNavigate: Boolean = false,
    iconButton: ImageVector = Icons.Default.ArrowBack,
) {

    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 19.sp
            )
        },
        backgroundColor = Red500,
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navController?.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "" ,
                        tint = Color.White
                    )
                }
            }
            if (otherIconNavigate) {
                IconButton(onClick = { navController?.popBackStack() }) {
                    Icon(
                        imageVector = iconButton,
                        contentDescription = "" ,
                        tint = Color.White
                    )
                }
            }
        }
    )

}