package com.example.fintech.screens
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fintech.R
import com.example.fintech.components.AppToolbar
import com.example.fintech.components.NavigationDrawerBody
import com.example.fintech.components.NavigationDrawerHeader
import com.example.fintech.data.home.HomeViewModel
import com.example.fintech.presentation.Screen
import com.example.fintech.presentation.coin_detail.CoinDetailScreen
import com.example.fintech.presentation.components.CoinListScreen
import kotlinx.coroutines.launch
import com.example.fintech.navigation.AppRouter
import com.example.fintech.navigation.ButtonHandler
import com.example.fintech.navigation.Screens

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(
                toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(
                navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere", "inside_NavigationItemClicked")
                    Log.d("ComingHere", "${it.itemId} ${it.title}")
                    // You can navigate to different screens based on the clicked item
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // This is where you can place the content of your HomeScreen
                NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
                    composable(route = Screen.CoinListScreen.route) {
                        CoinListScreen(navController = navController)
                    }
                    composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                        CoinDetailScreen()
                    }
                }
            }
        }
    }
    ButtonHandler {
        AppRouter.navigateTo(Screens.NextScreens)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
