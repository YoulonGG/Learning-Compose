package com.example.learningcompose
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learningcompose.Screens.HomeScreen
import com.example.learningcompose.Screens.NewsScreen
import com.example.learningcompose.Screens.ProfileScreen
import com.example.learningcompose.Screens.SearchScreen

@Composable
fun Route(navController: NavHostController) {

    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("search") { SearchScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("news") { NewsScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
    }
}