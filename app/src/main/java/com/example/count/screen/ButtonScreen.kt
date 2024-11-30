package com.example.count.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.count.CountViewModel
import com.example.count.ui.theme.CountTheme

@Composable
fun ButtonScreen(viewModel: CountViewModel = viewModel()) {
    val count = viewModel.count
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Count : ${count.value}")
        Button(
            onClick = {viewModel.increase()}
        ) {
            Text("Increase")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonScreenPreview() {
    CountTheme {
        ButtonScreen()
    }
}