package com.example.learningcompose.screens

import BottomNavigation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(navController: NavHostController) {

    var name by remember  { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    Scaffold(
        bottomBar = { BottomNavigation(navController) },
        modifier = Modifier
            .background(color = Color.Gray)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = name,
                onValueChange = {name = it},
                textStyle = TextStyle(fontSize = 18.sp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 32.dp))
            Row {
                Button(
                    onClick = { result = name }
                ) {
                    Text(text = "Submit")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { name = ""; result = "" }
                ) {
                    Text(text = "Clear")
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 42.dp)
            ) {
                Text(
                    text = "Hello",
                    fontSize = 32.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = result,
                    fontSize = 32.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
