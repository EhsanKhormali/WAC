package com.ehsankhormali.wac.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ehsankhormali.wac.screens.home.HomeScreen
import com.ehsankhormali.wac.screens.home.HomeScreenViewModel
import com.ehsankhormali.wac.screens.products.Products
import com.ehsankhormali.wac.screens.search.SearchScreen

@Composable
fun WacNavigation(navController: NavHostController) {
    val viewModel: HomeScreenViewModel = hiltViewModel()
    NavHost(navController = navController,
        startDestination = WacScreens.HomeScreen.name ){
        composable(WacScreens.HomeScreen.name){
            HomeScreen(navController = navController, viewModel = viewModel)
        }

        composable(WacScreens.SearchScreen.name){
            SearchScreen(navController = navController, viewModel = viewModel)
        }

        composable(WacScreens.ProductsScreen.name){
            Products(navController = navController)
        }
    }
}