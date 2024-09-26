package com.example.learningcompose
import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController?) {

    val txtUsername = remember { mutableStateOf(TextFieldValue()) }
    val txtPassword = remember { mutableStateOf(TextFieldValue()) }
    val styleTextField = TextStyle(fontSize = 16.sp)

    val green = colorResource(id = R.color.green)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Text(
                text = "Login",
                color = colorResource(id = R.color.white),
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(42.dp))

            TextField(
                value = txtUsername.value,
                textStyle = styleTextField,
                onValueChange = { txtUsername.value = it },
                placeholder = { Text(
                    "Username",
                    style = TextStyle(fontSize = 16.sp)
                ) },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 52.dp)
                    .shadow(elevation = 8.dp)
                    .height(48.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = txtPassword.value,
                textStyle = styleTextField,
                onValueChange = { txtPassword.value = it },
                placeholder = { Text(
                    "Password",
                    style = TextStyle(fontSize = 16.sp)
                ) },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 52.dp)
                    .shadow(elevation = 8.dp)
                    .height(48.dp)
            )

            Spacer(modifier = Modifier.height(42.dp))

            Button(
                onClick = {
                    navController?.navigate("Home")
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 52.dp)
                    .shadow(elevation = 8.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 16.dp)
            ) {
               Text(
                   text = "Forget your password?",
                   fontSize = 16.sp,
                   color = Color.White,
               )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sign Up",
                    fontSize = 16.sp,
                    color = green
                )
            }
//            Row(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Button(
//                    onClick = {},
//                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.white)),
//                    modifier = Modifier
//                        .shadow(elevation = 8.dp)
//                        .height(48.dp)
//                ) {
//                    Image(
//                        modifier = Modifier
//                            .width(35.dp)
//                            .height(35.dp),
//                        painter = painterResource(id = R.drawable.fbb),
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Text(
//                        text = "Facebook",
//                        fontSize = 18.sp,
//                        color = Color.White
//                    )
//                }

            }
        }
    }
//}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navController = null)
}






