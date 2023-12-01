package com.example.fintech.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fintech.data.home.HomeViewModel
import com.example.fintech.navigation.AppRouter
import com.example.fintech.navigation.Screens
import com.example.fintech.screens.*

@Composable

fun App(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screens.HomeScreens)
        }
        Crossfade(targetState = AppRouter.currentScreens, label = "") { currentState ->
            when (currentState.value) {
                is Screens.SignUpScreens -> {
                    SignUpScreen()
                }

                is Screens.TermsAndConditionsScreens -> {
                    TermsAndConditionsScreen()
                }

                is Screens.LoginScreens -> {
                    LoginScreen()
                }
                is Screens.NextScreens -> {
                    NextScreen()
                }
                is Screens.HomeScreens -> {
                    HomeScreen()
                }
                is Screens.GeckoScreens -> {
                    GeckoScreen()
                }
                is Screens.ChartScreens -> {
                    ChartScreen()
                }
            }
        }

    }
}