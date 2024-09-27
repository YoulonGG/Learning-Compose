package com.example.learningcompose
import UserViewModel
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learningcompose.screens.HomeScreen
import com.example.learningcompose.screens.NewsScreen
import com.example.learningcompose.screens.ProfileScreen
import com.example.learningcompose.screens.SearchScreen

@Composable
fun Route(navController: NavHostController) {

    val userViewModel: UserViewModel = viewModel()

    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController, userViewModel) }
        composable("home") { HomeScreen(navController) }
        composable("search") { SearchScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("news") { NewsScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
    }
}
