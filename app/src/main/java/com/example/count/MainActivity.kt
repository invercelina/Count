package com.example.count

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.count.ui.theme.CountTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountTheme {
                NavigatorScreen()
            }
        }
    }
}

@Composable
fun NavigatorScreen() {
    Column(
        Modifier.fillMaxSize()
    ) {

    }
}