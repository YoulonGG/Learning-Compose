//package com.example.learningcompose.BottomNavigation
//
//
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavController
//import androidx.navigation.compose.currentBackStackEntryAsState
//
//@Composable
//fun BottomNavigationBar(navController: NavController) {
//    val items = listOf(Screen.Home, Screen.Profile, Screen.Search)
//    BottomNavigation {
//        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
//        items.forEach { screen ->
//            BottomNavigationItem(
//                icon = { Icon(screen.icon, contentDescription = screen.title) },
//                label = { Text(screen.title) },
//                selected = currentRoute == screen.route,
//                onClick = {
//                    navController.navigate(screen.route) {
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}