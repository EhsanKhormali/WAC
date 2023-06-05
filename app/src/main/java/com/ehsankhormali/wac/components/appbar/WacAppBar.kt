package com.ehsankhormali.wac.components.appbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WacAppBar(){
    TopAppBar(
        title = { Text(text = "Post details")}
    )
}