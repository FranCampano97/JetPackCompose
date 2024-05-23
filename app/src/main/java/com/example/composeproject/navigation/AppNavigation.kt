package com.example.composeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeproject.screens.FacturaListScreen
import com.example.composeproject.screens.FiltradoScreen
import com.example.composeproject.screens.ForgotPasswordScreen
import com.example.composeproject.screens.LoginScreen
import com.example.composeproject.screens.NavigationScreen
import com.example.composeproject.screens.PrincipalScreen
import com.example.composeproject.screens.RegisterScreen
import com.example.composeproject.screens.TabScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {

        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.PrincipalScreen.route) {
            PrincipalScreen(navController)
        }
        composable(route = AppScreens.FacturaListScreen.route) {
            FacturaListScreen(navController)
        }
        composable(route = AppScreens.FiltradoScreen.route) {
            FiltradoScreen(navController)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(route = AppScreens.ForgotPasswordScreen.route) {
            ForgotPasswordScreen(navController)
        }

        composable(route = AppScreens.TabScreen.route) {
            TabScreen(navController)
        }
        composable(route = AppScreens.NavigationScreen.route) {
            NavigationScreen(navController)
        }
    }
}