package com.ehsankhormali.wac.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController:NavController){
    var userName by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        TextField(
            value = userName,
            onValueChange = {newValue ->
                userName=newValue
            },
            label = { Text(text = "UserName")}
        )

        TextField(
            value = password,
            onValueChange = {newValue ->
                password=newValue
            },
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation()
        )

    }
}