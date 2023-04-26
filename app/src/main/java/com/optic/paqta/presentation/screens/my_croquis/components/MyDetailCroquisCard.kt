package com.optic.paqta.presentation.screens.my_croquis.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.paqta.R
import com.optic.paqta.domain.model.PointDanger
import com.optic.paqta.presentation.screens.my_croquis.MyCroquisViewModel

@Composable
fun MyDetailCroquisCard(navCOntroller: NavHostController, point: PointDanger, viewModel: MyCroquisViewModel = hiltViewModel()){
    Card(
        modifier = Modifier
            .padding(top = 0.dp, bottom = 15.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        contentColor = Color.White,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = when (point.category) {
                    "ZONA DE ALTO RIESGO" -> R.drawable.baseline_dangerous_24
                    "ZONA DE ALTO PELIGRO" -> R.drawable.outline_warning_amber_24
                    "ZONA SEGURA" -> R.drawable.baseline_security_24
                    else -> {R.drawable.baseline_dangerous_24}
                }),
                contentDescription = "PELIGRO"
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(text = point.description)
        }
    }


}