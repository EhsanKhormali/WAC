package com.ehsankhormali.wac.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ehsankhormali.wac.screens.home.HomeScreen
import com.ehsankhormali.wac.screens.home.HomeScreenViewModel
import com.ehsankhormali.wac.screens.post.BlogPostScreen
import com.ehsankhormali.wac.screens.products.ProductsScreen
import com.ehsankhormali.wac.screens.profile.ProfileScreen
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
            ProductsScreen(navController = navController)
        }

        composable(WacScreens.ProfileScreen.name){
            ProfileScreen(navController = navController)
        }

        val postRout=WacScreens.BlogPostScreen.name
        composable("$postRout/{postId}",
            arguments = listOf(
                navArgument(name = "postId"){
                    type= NavType.IntType})
        ){navBack ->
            navBack.arguments?.getInt("postId")?.let {
                postId ->
                BlogPostScreen(navController = navController, postId = postId)
            }
        }
    }
}