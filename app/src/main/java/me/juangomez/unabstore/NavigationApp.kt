package me.juangomez.unabstore

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationApp() {
    val myNavController = rememberNavController()
    val myStartDestination: String = "login"

    NavHost(
        navController = myNavController,
        startDestination = myStartDestination
    ) {
        composable("login") {
            LoginScreen(onClickRegister = {
                myNavController.navigate("register")
            }, onSuccesfullLogin = {myNavController.navigate("home"){
                popUpTo("login"){inclusive = true}
            }
            })
        }
        composable("register") {
            RegisterScreen(onClickBack = {
                myNavController.popBackStack()
            }, onSuccessfulRegister = {
                myNavController.navigate("home"){
                    popUpTo(0)
                }
            })
        }
        composable("home") {
            HomeScreen()
        }
    }
}