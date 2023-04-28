package com.ehsankhormali.wac.screens.main

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ehsankhormali.wac.data.RequestState

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel= hiltViewModel()) {
    when (viewModel.postListState.value.state) {
        is RequestState.Success -> Text(text = "${viewModel.postListState.value.data?.get(0)?.content?.rendered}")
        is RequestState.Loading -> LinearProgressIndicator()
        is RequestState.Error -> Text(text = "${viewModel.postListState.value.state.message}")
        else -> Text(text = "I'm idle")
    }
}