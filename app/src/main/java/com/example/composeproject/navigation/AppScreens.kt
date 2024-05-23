package com.example.composeproject.navigation

sealed class AppScreens(val route:String) {
    object LoginScreen:AppScreens("LoginScreen")
    object PrincipalScreen:AppScreens("PrincipalScreen")
    object FacturaListScreen:AppScreens("FacturaListScreen")
    object FiltradoScreen:AppScreens("FiltradoScreen")
    object RegisterScreen:AppScreens("RegisterScreen")
    object ForgotPasswordScreen:AppScreens("ForgotPasswordScreen")
    object TabScreen:AppScreens("TabScreen")
    object NavigationScreen:AppScreens("NavigationScreen")

}