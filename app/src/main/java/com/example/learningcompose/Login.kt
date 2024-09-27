package com.example.learningcompose

import UserViewModel
import ValidationError
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import java.util.Locale

@Composable
fun LoginScreen(navController: NavController, viewModel: UserViewModel) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val styleTextField = TextStyle(fontSize = 18.sp)

//    val userState1 by viewModel.state.collectAsState()
    val userState by viewModel.state.collectAsStateWithLifecycle()
//    val userState2 = viewModel.state

    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        disabledContainerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )

    LaunchedEffect(userState.error) {
        if (userState.error == null && name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            navController.navigate("home")
        }
    }

    val green = colorResource(id = R.color.green)
    val orange = colorResource(id = R.color.orange)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Login",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(orange, green)
                    )
                )
            )
            Spacer(modifier = Modifier.height(42.dp))
            TextField(
                value = name,
                textStyle = styleTextField,
                onValueChange = { name = it },
                placeholder = { Text("Username", style = TextStyle(fontSize = 16.sp)) },
                isError = userState.error?.property == "name",
                shape = RoundedCornerShape(10.dp),
                colors = colors,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .shadow(elevation = 8.dp)
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = password,
                textStyle = styleTextField,
                placeholder = { Text("Password", style = TextStyle(fontSize = 16.sp)) },
                onValueChange = { password = it },
                isError = userState.error?.property == "password",
                shape = RoundedCornerShape(10.dp),
                colors = colors,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .shadow(elevation = 8.dp)
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = email,
                textStyle = styleTextField,
                onValueChange = { email = it },
                placeholder = { Text("Email", style = TextStyle(fontSize = 16.sp)) },
                isError = userState.error?.property == "email",
                shape = RoundedCornerShape(10.dp),
                colors = colors,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .shadow(elevation = 8.dp)
                    .height(50.dp)
            )
            userState.error?.let { error ->
                Text(
                    text = error.message,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .padding(top = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    val fields = mapOf("name" to name, "email" to email, "password" to password)
                    fields.entries.firstOrNull { it.value.isEmpty() }?.let { (field, _) ->
                        viewModel.updateProperty(
                            userState.copy(
                                error = ValidationError(field, "${field.replaceFirstChar { it.titlecase(Locale.ROOT) }} cannot be empty")
                            )
                        )
                    } ?: run {
                        viewModel.updateProperty(userState.copy(name = name, email = email, password = password))
                        viewModel.save()
                    }
            },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .shadow(elevation = 8.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Forget your password?",
                    fontSize = 16.sp,
                    color = Color.Gray,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sign Up",
                    fontSize = 16.sp,
                    color = green,
                    modifier = Modifier.clickable { navController.navigate("signup") }
                )
            }
            Text(
                text = "Or Sign in with",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 32.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(top = 10.dp)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.white)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .shadow(elevation = 8.dp)
                        .height(48.dp)
                        .weight(1f)
                ) {
                    Image(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp),
                        painter = painterResource(id = R.drawable.fbb),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Facebook",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.white)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .shadow(elevation = 8.dp)
                        .height(48.dp)
                        .weight(1f)
                ) {
                    Image(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp),
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Google",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
