package com.example.learningcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
//        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.green)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = null,
                modifier = Modifier.width(80.dp).height(80.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

//            Text(text = "Welcome", fontSize = 24.sp, color = Color.Green)
        }
    }

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("Login")
    }
}
