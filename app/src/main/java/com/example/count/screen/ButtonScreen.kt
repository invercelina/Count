package com.example.count.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.count.Button
import com.example.count.Count
import com.example.count.CountViewModel
import com.example.count.R

@Composable
fun ButtonScreen(navController: NavController, viewModel: CountViewModel) {
    val count = viewModel.count.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Count : ${count.value}")
        Button(
            onClick = { viewModel.increase() }
        ) {
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                )
                Text("Increase")
            }
        }
        Button(
            onClick = {
                navController.navigate(Count) {
                    popUpTo<Button> { inclusive = true }
                }
            }
        ) {
            Text("Back")
        }
    }
}
