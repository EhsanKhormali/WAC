package com.ehsankhormali.wac.screens.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ehsankhormali.wac.R
import com.ehsankhormali.wac.components.LoadingScreen
import com.ehsankhormali.wac.data.RequestState

@Composable
fun BlogPostScreen(
    navController: NavController,
    viewModel: BolgPostScreenViewModel = hiltViewModel(),
    postId: Int
) {
    viewModel.getPost(postId)
    val scrollState = rememberScrollState()
    when (viewModel.embeddablePostStateApiRequest.value.state) {
        is RequestState.Success ->
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .verticalScroll(scrollState)
            ) {
                viewModel.embeddablePostStateApiRequest.value.data?.let { post ->
                    AsyncImage(
                        model = post.embedded.wpFeaturedMedia?.get(0)?.mediaDetails?.sizes?.full?.sourceUrl,
                        contentDescription = "",
                        error = painterResource(id = R.drawable.image_placeholder),
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = post.title.rendered,
                        modifier = Modifier.fillMaxWidth(),
                        style =MaterialTheme.typography.headlineMedium.copy(
                            textDirection = TextDirection.Content)
                    )
                    Text(
                        text = post.content.rendered,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(textDirection = TextDirection.Content)
                    )
                }

            }

        is RequestState.Idle ->
            Text(text = "I,m Idle now")

        is RequestState.Error ->
            Text(text = "${viewModel.embeddablePostStateApiRequest.value.state.message}")

        is RequestState.Loading ->
            LoadingScreen()
    }
}