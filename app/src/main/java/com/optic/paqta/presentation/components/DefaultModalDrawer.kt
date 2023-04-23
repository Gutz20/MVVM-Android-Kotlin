package com.optic.paqta.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.optic.paqta.R
import com.optic.paqta.presentation.navigation.DetailsScreen
import com.optic.paqta.presentation.screens.my_backpack.MyBackpacksScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DefaultModalDrawer(
    navController: NavHostController
) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalDrawer(
        drawerState = drawerState,

        drawerContent = {
            Column {
                Text(text = "Paqta Application")
                Image(
                    modifier = Modifier.size(110.dp),
                    painter = painterResource(id = R.drawable.logologin),
                    contentDescription = "",
                )
                Button(onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }) {
                    Text(text = "Close Drawer")
                }
                IconButton(
                    onClick = { /*TODO*/ }
                ) {

                }
                Divider()
                ListItem(
                    text = { Text("Mi Mochila") },
                    icon = {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Mi Mochila"
                        )
                    },
                    modifier = Modifier.clickable{
                    }
                )
                ListItem(
                    text = { Text("Mi Diario") },
                    icon = {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Mi Diario"
                        )
                    },
                    modifier = Modifier.clickable{}
                )
                ListItem(
                    text = { Text("Atencion Especial") },
                    icon = {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Atencion Especial"
                        )
                    },
                    modifier = Modifier.clickable{}
                )
            }
        },
        content = {
            DefaultTopBar(
                title = "Mi Mochila",
                otherIconNavigate = true,
                iconButton = Icons.Default.Menu,
                actionButton = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )


        }
    )
}
