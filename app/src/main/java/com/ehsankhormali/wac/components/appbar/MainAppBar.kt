package com.ehsankhormali.wac.components.appbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(query: String, navController: NavController,onProfileClick:()->Unit = {}) {
    var text by rememberSaveable { mutableStateOf(query) }
    var active by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchBar(
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(text = "Search") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            trailingIcon = {
                IconButton(onClick = onProfileClick ) {
                    Icon(
                        painter = rememberAsyncImagePainter(
                            model = "",
                            error = rememberVectorPainter(image = Icons.Default.Person)
                        ),
                        contentDescription =""
                    )
                }
                           },
            shape = CircleShape,
            modifier = Modifier
                .padding(5.dp)
                .weight(weight = 1f, fill = true)

        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(4) { idx ->
                    val resultText = "Suggestion $idx"
                    ListItem(
                        headlineContent = { Text(resultText) },
                        supportingContent = { Text("Additional info") },
                        leadingContent = { Icon(Icons.Filled.Star, contentDescription = null) },
                        modifier = Modifier.clickable {
                            text = resultText
                            active = false
                        }
                    )
                }
            }
        }


        /*if (!active) {
            IconButton(
                onClick = { *//*TODO*//* },
                modifier = Modifier
                    .padding(5.dp)
                    .size(55.dp)
                    .background(Color.Cyan)
            ) {
                AsyncImage(
                    model = "",
                    contentDescription = "profile picture",
                    error = rememberVectorPainter(image = Icons.Default.Person)

                )
            }
        }*/


    }
}

fun searchContent(query: String) {

}

@Composable
@Preview
fun MainAppBarPreview() {
    MainAppBar(query = "", navController = rememberNavController()){}
}