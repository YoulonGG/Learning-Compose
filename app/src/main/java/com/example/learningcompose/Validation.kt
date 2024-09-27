import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class UserState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val error: ValidationError? = null
)

data class ValidationError(
    val property: String = "",
    val message: String = ""
)

class UserViewModel : ViewModel() {

    //We use MutableStateFlow to hold multiple pieces of state
    private val _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state

    fun updateProperty(newState: UserState) {
//        _state.value = newState
        // Use update to ensure that your state updates are performed correctly
        //and update is from MutableStateFlow
        _state.update { newState }
    }

    fun save() {
        val error = validate(state.value)

        _state.update { currentState ->
            currentState.copy(error = error)
        }
    }

    private fun validate(userState: UserState): ValidationError? {
        if (userState.name.isEmpty()) {
            return ValidationError("name", "This field cannot be empty")
        }
        if (!isValidEmail(userState.email)) {
            return ValidationError("email", "Invalid email format")
        }
        if (!isValidPassword(userState.password)) {
            return ValidationError("password", "Password must include letters and numbers")
        }
        return null
    }

    private fun isValidEmail(email: String): Boolean {
        return Regex("^[A-Za-z](.*)(@)(.+)(\\.)(.+)").matches(email)
    }

    private fun isValidPassword(password: String): Boolean {
        return Regex("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{5,}$").matches(password)
    }
}
