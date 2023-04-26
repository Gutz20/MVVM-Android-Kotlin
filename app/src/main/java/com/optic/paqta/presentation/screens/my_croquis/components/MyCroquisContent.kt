package com.optic.paqta.presentation.screens.my_croquis.components

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.optic.paqta.R
import com.optic.paqta.domain.model.PointDanger
import com.optic.paqta.presentation.components.DefaultButton
import com.optic.paqta.presentation.components.DialogCapturePicture
import com.optic.paqta.presentation.navigation.DetailsScreen
import com.optic.paqta.presentation.screens.my_croquis.MyCroquisViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyCroquisContent(
    navController: NavHostController,
    viewModel: MyCroquisViewModel = hiltViewModel(),
    points: List<PointDanger>
) {

//    PARA REDIRIGIR A UNA WEB
//    val webIntent: Intent = Uri.parse("com.whatsapp").let { webpage ->
//        Intent(Intent.ACTION_VIEW, webpage)
//    }
//    webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

    val appPackageName = "pl.planmieszkania.android"
    var appIntent: Intent
    appIntent = try {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("market://details?id=$appPackageName")
        )
    } catch (e: ActivityNotFoundException) {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
        )
    }
    appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()
    var dialogState = remember { mutableStateOf(false) }
    DialogCapturePicture(
        status = dialogState,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() }
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = "Realice su croquis aqui"
        )
        DefaultButton(
            modifier = Modifier.padding(5.dp),
            text = "Enlace aqui",
            color = Color.White,
            onClick = {
                //REDIRECCIONAR A OTRA APP
                ContextCompat.startActivity(viewModel.context, appIntent, null)
            }
        )
        Text(
            fontWeight = FontWeight.Bold,
            text = "Subamos el Croquis de su Hogar",
        )

        Spacer(modifier = Modifier.padding(10.dp))

        if (viewModel.state.imageMapping != "") {
//                    Log.d("ProfileUpdateContent", "image: ${viewModel.state.image}")
            AsyncImage(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp)
                    .clickable {
                        dialogState.value = true
                    },
                model = viewModel.state.imageMapping,
                contentDescription = "Selected image",
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                modifier = Modifier
                    .height(200.dp)
                    .clickable {
                        dialogState.value = true
                    },
                painter = painterResource(id = R.drawable.add_image),
                contentDescription = "Imagen de usuario"
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
        DefaultButton(
            modifier = Modifier.padding(5.dp),
            text = "ACTUALIZAR",
            color = Color.White,
            onClick = { }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
        ) {
            items(
                items = points
            ) { point ->
                MyDetailCroquisCard(navCOntroller = navController, point = point)
            }
        }
    }
}
