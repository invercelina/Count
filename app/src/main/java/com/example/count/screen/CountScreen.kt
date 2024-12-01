package com.example.count.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.count.Button
import com.example.count.CountViewModel

@Composable
fun CountScreen(navController: NavController, viewModel: CountViewModel) {
    val count = viewModel.count.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Count:\n${count.value}")
        Spacer(Modifier.height(40.dp))
        Button(onClick = { navController.navigate(Button) }) {
            Text("to ButtonScreen")
        }
    }
}

