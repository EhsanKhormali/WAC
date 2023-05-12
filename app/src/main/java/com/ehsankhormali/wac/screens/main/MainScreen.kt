package com.ehsankhormali.wac.screens.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ehsankhormali.wac.components.appbar.MainAppBar
import com.ehsankhormali.wac.components.wac_bottom_navigation.WacBottomNavigation
import com.ehsankhormali.wac.navigation.WacNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController= rememberNavController()
    Scaffold(
        modifier = Modifier,
        topBar = {
            Row() {
            MainAppBar(query = "", navController = navController)
            }
                 },
        bottomBar = { WacBottomNavigation(navController) }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            WacNavigation(navController = navController)
        }
    }
}