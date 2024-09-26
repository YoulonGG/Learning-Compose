import androidx.annotation.DrawableRes
import com.example.learningcompose.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    val label: String)

data object Home : BottomNavItem("home", icon = R.drawable.home, "Home")
data object Search : BottomNavItem("search", icon = R.drawable.search, "Search")
data object Profile : BottomNavItem("profile", icon = R.drawable.user, "Profile")
data object News : BottomNavItem("news", icon = R.drawable.news, "News")