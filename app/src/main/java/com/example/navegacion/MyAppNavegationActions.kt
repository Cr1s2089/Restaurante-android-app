package com.example.navegacion


import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.navegacion.ui.icons.FriedChickenIcon
import com.example.navegacion.ui.icons.HamburguesaIcon
import com.example.navegacion.ui.icons.HotDogIcon

class MyAppNavegationActions (private val navController: NavHostController){
    fun navigateTo(destination: MyAppTopLevelDestination){
        navController.navigate(destination.route){
            popUpTo(navController.graph.findStartDestination().id){
                saveState=true
            }
            launchSingleTop=true
        }
    }
}

data class MyAppTopLevelDestination(
    val route:String,
    val selectedIcon: ImageVector,
    val iconTextId:Int

)
val TOP_LEVEL_DETINATIONS = listOf(
    MyAppTopLevelDestination(
        route = MyAppRoute.HAMBURGUESA,
        selectedIcon = HamburguesaIcon,
        iconTextId =R.string.home
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.SALCHICHA,
        selectedIcon = HotDogIcon,
        iconTextId =R.string.account
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.ALITAS,
        selectedIcon = FriedChickenIcon,
        iconTextId =R.string.settings
    ),
)

object MyAppRoute{
    const val MAIN_SCREEN="MAIN_ SCREEN"
    const val HAMBURGUESA = "HAMBURGUESA"
    const val SALCHICHA = "SALCHICHA"
    const val ALITAS = "ALITAS"

}