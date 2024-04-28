package com.ehsankhormali.wac.screens.profile

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ehsankhormali.wac.navigation.WacScreens
import com.ehsankhormali.wac.widgets.ProfileImage

@Composable
fun ProfileScreen(navController: NavController){
    if (!true ) {///TODO:check if user is logged in
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = { navController.navigate(WacScreens.LoginScreen.name) }) {
                Text(text = "Pleas login")
            }
        }

    }else{
        Profile(navController = navController)
    }
}

@Composable
fun Profile(navController: NavController) {
    var firstName: String by remember {
        mutableStateOf("")
    }
    var lastName: String by remember {
        mutableStateOf("")
    }

    var editFirstName: String by remember {
        mutableStateOf("")
    }
    var editLastName: String by remember {
        mutableStateOf("")
    }

    var picUrl: String by remember {
        mutableStateOf("")
    }
    var editMode by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        // Actions to perform when LaunchedEffect enters the Composition
        ///TODO: load user information
                firstName = "first_name"
                lastName = "last_name"
                picUrl = "profile_picture"
                editFirstName=firstName
                editLastName=lastName
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 25.dp))
        ProfileImage(Uri.parse(picUrl)) {
            updateProfilePicture(it)
        }


        Spacer(modifier = Modifier.padding(vertical = 25.dp))
        OutlinedTextField(
            value = editFirstName, onValueChange = {
                editFirstName = it
            },
            label = { Text(text = "First name") },
            readOnly = !editMode
        )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        OutlinedTextField(
            value = editLastName, onValueChange = {
                editLastName = it
            },
            label = { Text(text = "Last name") },
            readOnly = !editMode
        )
        Spacer(modifier = Modifier.padding(vertical = 25.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {

                    if (editMode) {
                        ///TODO: edit current user
                    }
                    editMode = !editMode

                },
                modifier = Modifier
                    .height(40.dp),
            ) {
                Text(
                    text = if (!editMode) "Edit Profile" else "Save"
                )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Icon(
                    imageVector = if (!editMode) Icons.Default.Edit else Icons.Default.Save,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            // sign out button
            Button(
                onClick = {
                    ///TODO: sign out the user
                    navController.navigate(WacScreens.LoginScreen.name)
                },
                modifier = Modifier
                    .height(40.dp),
            ) {
                Text(
                    text = "Log Out!!"
                )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
        }

    }
}

private fun updateProfilePicture(uri: Uri) {
    ///TODO: update user profile picture asynchronously

}

@Preview
@Composable
fun PreviewProfile(navController: NavController= rememberNavController()){
    Profile(navController = navController)
}