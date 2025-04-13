package com.example.chatapplication.presentation.Activites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.constants.Destinations
import com.example.chatapplication.presentation.Screens.Auth.LoginScreen
import com.example.chatapplication.presentation.Screens.Auth.RegisterScreen
import com.example.chatapplication.presentation.Screens.addroom.AddRoomScreen
import com.example.chatapplication.presentation.Screens.home.HomeScreen
import com.example.chatapplication.presentation.Screens.splash.SplashScreen
import com.example.chatapplication.presentation.theme.ChatApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavGraph(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash",
        modifier = modifier
    ) {
        composable(Destinations.SPLASH){
            SplashScreen(
                navController = navController
            )
        }
        composable(Destinations.SIGN_IN) {
            LoginScreen(
                navController = navController
            )
        }
        composable(Destinations.SIGN_UP) {
            RegisterScreen(navController = navController)
        }
        composable(Destinations.HOME) {
            HomeScreen(navController = navController)
        }
        composable(Destinations.ADD_ROOM) {
            AddRoomScreen(navController = navController)
        }
    }

}

