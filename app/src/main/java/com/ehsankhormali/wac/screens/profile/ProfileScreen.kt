package com.ehsankhormali.wac.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ehsankhormali.wac.navigation.WacScreens

@Composable
fun ProfileScreen(navController: NavController){
    if (true ) {// if not logged in
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = { navController.navigate(WacScreens.LoginScreen.name) }) {
                Text(text = "Pleas login")
            }
        }

    }
}