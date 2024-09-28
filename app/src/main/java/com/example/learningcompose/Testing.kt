import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.learningcompose.FormViewModel

@Composable
fun FormScreen(viewModel: FormViewModel) {
    val username by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }
    val email by remember { mutableStateOf("") }

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = state.userName,
            onValueChange = { viewModel.updateUserName(it) },
            label = { Text("Username") },
            isError = state.userNameError != null,
        )
        if (state.userNameError != null) {
            Text(
                text = state.userNameError!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }



        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.password,
            onValueChange = { viewModel.updatePassword(it) },
            label = { Text("Password") },
            isError = state.passwordError != null && !isValidPassword(state.password),
        )
        if (state.passwordError != null) {
            Text(
                text = state.passwordError!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        } else if (!isValidPassword(state.password)) {
            Text(
                text = "Your password is not valid",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.email,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text("Email") },
            isError = state.emailError != null && !isValidEmail(state.email),
        )
        if (state.emailError != null) {
            Text(
                text = state.emailError!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        } else if (!isValidEmail(state.email)) {
            Text(
                text = "Your email is not valid",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }


        Button(
            onClick = { viewModel.validate() },

        ) {
            Text("Validate")
        }
    }
}

fun isValidEmail(email: String): Boolean {
    return Regex("^[A-Za-z](.*)(@)(.+)(\\.)(.+)").matches(email)
}
private fun isValidPassword(password: String): Boolean {
    return Regex("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{5,}$").matches(password)
}

