package com.ehsankhormali.wac.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ehsankhormali.wac.data.RequestState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel) {

            when (viewModel.postListState.value.state) {
                is RequestState.Success ->
                {
                    LazyColumn(){
                        items(items = viewModel.postListState.value.data.orEmpty()){postItem ->
                            Card(modifier = Modifier.padding(5.dp), elevation = CardDefaults.cardElevation()) {
                                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Text(
                                            text = postItem.title.rendered,
                                            style = MaterialTheme.typography.headlineMedium
                                        )
                                        Text(text = postItem.excerpt.rendered)
                                    }
                                }
                            }
                    }
                    }

                }
                is RequestState.Loading -> LinearProgressIndicator()
                is RequestState.Error -> Text(text = "${viewModel.postListState.value.state.message}")
                else -> Text(text = "I'm idle")
        }

    }