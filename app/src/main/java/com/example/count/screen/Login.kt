package com.example.count.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.count.Count
import com.example.count.CountViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: CountViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        var value by remember { mutableStateOf("") }
        TextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Name") }
        )

        Button(
            onClick = {
                if (value.isNotEmpty()) {
                    viewModel.login(value)
                    navController.navigate(Count)
                }
                else {
                    Toast.makeText(context, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Login")
        }
    }
}