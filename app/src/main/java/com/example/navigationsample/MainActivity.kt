package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val innerPaddng = innerPadding
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstscreen") {
        composable(route = "firstscreen",) {
            FirstScreen { userName, userAge ->
                navController.navigate("secondscreen/$userName/$userAge")
            }
        }
        composable(
            route = "secondscreen/{userName}/{userAge}",
            arguments = listOf(navArgument("userName") { type = NavType.StringType },
                navArgument("userAge") { type = NavType.IntType })
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "No Name"
            val userAge = backStackEntry.arguments?.getInt("userAge") ?: 0
            SecondScreen(
                userName,
                userAge,
                navigateFirstScreen = { navController.navigate(route = "firstscreen") })
        }
    }
}
