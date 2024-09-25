//package com.example.learningcompose.BottomNavigation
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.ui.graphics.vector.ImageVector
//
//sealed class Screen(val route: String, val icon: ImageVector, val title: String) {
//    data object Home : Screen("home", Icons.Default.Home, "Home")
//    data object Profile : Screen("profile", Icons.Default.Person, "Profile")
//    data object Search : Screen("search", Icons.Default.Settings, "Settings")
//}