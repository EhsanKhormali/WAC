package com.ehsankhormali.wac

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ehsankhormali.wac.components.appbar.MainAppBar
import com.ehsankhormali.wac.components.appbar.WacAppBar
import com.ehsankhormali.wac.components.wac_bottom_navigation.WacBottomNavigation
import com.ehsankhormali.wac.navigation.WacNavigation
import com.ehsankhormali.wac.navigation.WacScreens
import com.ehsankhormali.wac.ui.theme.WACTheme
import com.ehsankhormali.wac.utils.getTitleByRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WacApp(){
    WACTheme {
        val navController = rememberNavController()
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val rout = navBackStackEntry.value?.destination?.route
        val bottomBarRoutes= listOf("HomeScreen","ProductsScreen")
        val mainAppBarRoutes= listOf("HomeScreen","ProductsScreen")
        val shouldShowBottomBar:Boolean=rout in bottomBarRoutes
        val shouldShowMainAppBar= rout in mainAppBarRoutes
        var title: String by remember{
            mutableStateOf("")
        }
        title=getTitleByRoute(route = rout ?: "")
        Scaffold(
            topBar = {
                    if (shouldShowMainAppBar)
                        MainAppBar(query = "", navController = navController){
                            navController.navigate(WacScreens.ProfileScreen.name)
                        }
                    else
                        WacAppBar(navController = navController,title=title)

            },
            bottomBar = {
                if (shouldShowBottomBar)
                        WacBottomNavigation(navController = navController)

            }
        ) {
            Surface(modifier = Modifier.padding(it)) {
                WacNavigation(navController = navController)
            }
        }
    }
}
