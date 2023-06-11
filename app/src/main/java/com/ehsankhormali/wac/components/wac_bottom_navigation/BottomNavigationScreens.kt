package com.ehsankhormali.wac.components.wac_bottom_navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.ehsankhormali.wac.R
import com.ehsankhormali.wac.navigation.WacScreens

sealed class BottomNavigationScreens(val route:String, @StringRes val resourceId: Int, val icon: ImageVector){
    object Home:BottomNavigationScreens(
        route= WacScreens.HomeScreen.name,
        resourceId= R.string.home,
        icon=Icons.Default.Home
    )

    object Products:BottomNavigationScreens(
        WacScreens.ProductsScreen.name,
        R.string.products,
        Icons.Default.Info
    )
}
