package com.example.fintech.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screens(val route: String) {

    object SignUpScreens : Screens("signup_screen")
    object TermsAndConditionsScreens : Screens("terms_screen")
    object LoginScreens : Screens("login_screen")
    object NextScreens : Screens("next_screen")
     object HomeScreens : Screens("home_screen")
    object GeckoScreens : Screens("gecko_screen")
    object ChartScreens : Screens("chart_screen")
}


object AppRouter {

    var currentScreens: MutableState<Screens> = mutableStateOf(Screens.SignUpScreens)

    fun navigateTo(destination : Screens){
        currentScreens.value = destination
    }


}