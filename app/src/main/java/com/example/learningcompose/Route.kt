package com.example.learningcompose
import FormScreen
import UserViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learningcompose.screens.HomeScreen
import com.example.learningcompose.screens.NewsScreen
import com.example.learningcompose.screens.ProfileScreen
import com.example.learningcompose.screens.SearchScreen

@Composable
fun Route(navController: NavHostController) {

    val userViewModel = UserViewModel()
    val testViewModel = FormViewModel()

    NavHost(navController, startDestination = "test") {
        composable("test") { FormScreen(testViewModel) }
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController, userViewModel) }
        composable("home") { HomeScreen(navController) }
        composable("search") { SearchScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("news") { NewsScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
    }
}
