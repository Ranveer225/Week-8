package edu.farmingdale.pizzapartybottomnavbar

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@Composable
fun NavigationGraph(navController: NavHostController, onBottomBarVisibilityChanged: (Boolean) -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column {
                TextButton(onClick = { navigateAndCloseDrawer(navController, BottomNavigationItems.Welcome.route, scope, drawerState) }) {
                    Text("Welcome")
                }
                TextButton(onClick = { navigateAndCloseDrawer(navController, BottomNavigationItems.PizzaScreen.route, scope, drawerState) }) {
                    Text("Pizza Party")
                }
                TextButton(onClick = { navigateAndCloseDrawer(navController, BottomNavigationItems.GpaAppScreen.route, scope, drawerState) }) {
                    Text("GPA App")
                }
                TextButton(onClick = { navigateAndCloseDrawer(navController, BottomNavigationItems.Screen3.route, scope, drawerState) }) {
                    Text("Screen 3")
                }
            }
        }
    ) {
        NavHost(navController, startDestination = BottomNavigationItems.Welcome.route) {
            composable(BottomNavigationItems.Welcome.route) {
                onBottomBarVisibilityChanged(false)
                SplashScreen(navController = navController)
            }
            composable(BottomNavigationItems.PizzaScreen.route) {
                onBottomBarVisibilityChanged(true)
                PizzaPartyScreen()
            }
            composable(BottomNavigationItems.GpaAppScreen.route) {
                onBottomBarVisibilityChanged(true)
                GpaAppScreen()
            }
            composable(BottomNavigationItems.Screen3.route) {
                onBottomBarVisibilityChanged(true)
                Screen3()
            }
        }
    }
}
fun navigateAndCloseDrawer(navController: NavHostController, route: String, scope: kotlinx.coroutines.CoroutineScope, drawerState: DrawerState) {
    scope.launch {
        navController.navigate(route)
        drawerState.close()
    }
}
// ToDo 8: This is the homework:
// add a drawer navigation as described in drawable drawermenu.png
// Improve the design and integration of the app for 5 extra credit points.