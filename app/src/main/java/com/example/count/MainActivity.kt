package com.example.count

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.count.screen.ButtonScreen
import com.example.count.screen.CountScreen
import com.example.count.screen.LoginScreen
import com.example.count.ui.theme.CountTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountTheme {
                SampleApp()
            }
        }
    }
}

@Serializable
object Count

@Serializable
object Button

@Serializable
object Login

@Composable
fun SampleApp() {
    val navController = rememberNavController()
    val sharedViewModel: CountViewModel = viewModel()

    SampleNavHost(navController = navController, viewModel = sharedViewModel)
}

@Composable
fun SampleNavHost(
    navController: NavHostController,
    viewModel: CountViewModel
) {
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> { LoginScreen(navController, viewModel) }
        composable<Count> { CountScreen(navController, viewModel) }
        composable<Button> { ButtonScreen(navController, viewModel) }
    }
}
