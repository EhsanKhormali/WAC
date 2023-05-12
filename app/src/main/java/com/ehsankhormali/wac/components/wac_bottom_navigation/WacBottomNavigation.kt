package com.ehsankhormali.wac.components.wac_bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun WacBottomNavigation(navController: NavController){
    val bottomNavigation= listOf(BottomNavigationScreen.Home,BottomNavigationScreen.Products)
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination=navBackStackEntry?.destination
        bottomNavigation.forEach {screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any{it.route==screen.route}==true,
                onClick = {
                          navController.navigate(screen.route){
                              // Pop up to the start destination of the graph to
                              // avoid building up a large stack of destinations
                              // on the back stack as users select items
                              popUpTo(navController.graph.findStartDestination().id) {
                                  saveState = true
                              }
                              // Avoid multiple copies of the same destination when
                              // reselecting the same item
                              launchSingleTop = true
                              // Restore state when reselecting a previously selected item
                              restoreState = true
                          }
                },
                icon = { Icon(
                    imageVector = screen.icon,
                    contentDescription = "home navigation"
                )}
            )
        }
    }
}