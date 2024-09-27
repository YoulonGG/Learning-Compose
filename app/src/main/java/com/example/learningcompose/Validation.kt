import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

class UserViewModel : ViewModel() {
    private val _state: MutableStateFlow<UserState> = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state

    // Update state when validation is performed
    fun updateProperty(newState: UserState) {
        _state.update { newState }
    }

    fun save() {
        val stateValidator = ValidateState(UserState::class)
        val error = stateValidator.validate(state.value)

        _state.update { currentState ->
            currentState.copy(error = error)
        }
    }
}

data class UserState(

    @property:NotEmptyValidation
    val name: String = "",

    @property:EmailValidation
    val email: String = "",

    @property:PasswordValidation
    val password: String = "",

    val error: ValidationError? = null
)


@Target(AnnotationTarget.PROPERTY)
annotation class NotEmptyValidation

@Target(AnnotationTarget.PROPERTY)
annotation class EmailValidation

@Target(AnnotationTarget.PROPERTY)
annotation class PasswordValidation

// Validation error data class
data class ValidationError(
    val property: String = "",
    val message: String = ""
)

class ValidateState<State : Any>(
    private val kClass: KClass<State>
) {
    fun validate(state: State): ValidationError? {
        kClass.memberProperties.forEach { property ->
            val annotations = property.annotations
            if (annotations.isEmpty()) return@forEach

            val value = property.get(state)

            annotations.forEach { annotation ->
                when (annotation) {
                    is NotEmptyValidation -> {
                        if (isEmpty(value)) {
                            return ValidationError(property.name, "This field cannot be empty")
                        }
                    }
                    is EmailValidation -> {
                        if (isNotEmail(value)) {
                            return ValidationError(property.name, "Invalid email format")
                        }
                    }
                    is PasswordValidation -> {
                        if (isNotPassword(value)) {
                            return ValidationError(property.name, "Password must including letters and numbers")
                        }
                    }
                }
            }
        }
        return null
    }

    private fun isEmpty(value: Any?): Boolean {
        return value?.toString()?.isEmpty() ?: true
    }

    private fun isNotEmail(value: Any?): Boolean {
        return !Regex("^[A-Za-z](.*)(@)(.+)(\\.)(.+)").matches(value.toString())
    }

    private fun isNotPassword(value: Any?): Boolean {
        return !Regex("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{5,}$").matches(value.toString())
    }
}