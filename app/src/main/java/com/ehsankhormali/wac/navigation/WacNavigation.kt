package com.ehsankhormali.wac.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ehsankhormali.wac.screens.main.HomeScreen

@Composable
fun WacNavigation() {
    val navController= rememberNavController()
    NavHost(navController =navController,
        startDestination = WacScreens.HomeScreen.name ){
        composable(WacScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
    }
}