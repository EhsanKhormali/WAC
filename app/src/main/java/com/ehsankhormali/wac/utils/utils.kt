package com.ehsankhormali.wac.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ehsankhormali.wac.R

@Composable
fun getTitleByRoute(route:String): String {
    return when (route) {
        "HomeScreen" -> stringResource(id = R.string.home_screen_title)
        "ProductsScreen" -> stringResource(id = R.string.products_screen_title)
        "BlogPostScreen/{postId}"-> stringResource(id = R.string.post_screen_title)
        "ProfileScreen" -> stringResource(id = R.string.profile_screen_title)
        "" -> ""
        else -> ""
    }
}