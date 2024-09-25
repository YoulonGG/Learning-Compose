//package com.example.learningcompose.BottomNavigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.learningcompose.HomeScreen
//import com.example.learningcompose.ProfileScreen
//import com.example.learningcompose.SearchScreen
//
//@Composable
//fun NavGraph(navController: NavHostController) {
//    NavHost(navController, startDestination = Screen.Home.route) {
//        composable(Screen.Home.route) { HomeScreen(navController) }
//        composable(Screen.Profile.route) { ProfileScreen() }
//        composable(Screen.Search.route) { SearchScreen() }
//    }
//}
