package com.ehsankhormali.wac.screens.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ehsankhormali.wac.components.appbar.WacAppBar

@Composable
fun BlogPostScreen(navController: NavController, viewModel: BolgPostScreenViewModel = hiltViewModel(),postId: Int) {
    Scaffold(modifier = Modifier, topBar = {WacAppBar()}) {
        Surface(modifier = Modifier.padding(it)) {
            Column(modifier = Modifier.padding(5.dp)) {
                viewModel.embeddablePostState.value?.let{post ->  Text(text = post.title.rendered) }
                viewModel.getPost(postId)
            }
        }
    }
}