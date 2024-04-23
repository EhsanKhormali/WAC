package com.ehsankhormali.wac.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ehsankhormali.wac.R
import com.ehsankhormali.wac.widgets.HtmlTextView
import com.ehsankhormali.wac.components.LoadingScreen
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.navigation.WacScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel) {
    Surface(modifier = Modifier) {
        val listState= rememberLazyListState()

        when (viewModel.requestState.value) {
            is RequestState.Success -> {
                LazyColumn(state = listState) {
                    val itemCount=viewModel.postListState.count()
                    items(count = itemCount ){index ->
                        val postItem= viewModel.postListState[index]
                        Card(
                            modifier = Modifier.padding(5.dp),
                            elevation = CardDefaults.cardElevation(),
                            onClick = { navController.navigate(WacScreens.BlogPostScreen.name + "/${postItem.id}") }
                        ) {
                            Column {

                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AsyncImage(
                                        model = postItem.embedded.wpFeaturedMedia?.let { it[0].mediaDetails?.sizes?.medium?.sourceUrl },
                                        placeholder = painterResource(id = R.drawable.image_placeholder),
                                        error = painterResource(id = R.drawable.image_placeholder),
                                        contentDescription = null,
                                        modifier = Modifier.size(70.dp)
                                    )
                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Text(
                                            text = postItem.title.rendered,
                                            style = MaterialTheme.typography.headlineSmall.copy(textDirection = TextDirection.Content),
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                        HtmlTextView(text = postItem.excerpt.rendered, textSize = 15f, modifier = Modifier.fillMaxWidth())
                                    }
                                }
                                HorizontalDivider(thickness = 1.dp)
                                Row(
                                    modifier = Modifier
                                        .height(45.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ) {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.chat_bubble_fill0_wght400_grad0_opsz48),
                                            contentDescription = "",
                                            modifier = Modifier.size(24.dp)
                                        )
                                        Text(
                                            text = (postItem.embedded.replies?.get(0)?.size
                                                ?: 0).toString(),
                                            style = MaterialTheme.typography.labelSmall
                                        )
                                    }

                                    Row(
                                        modifier = Modifier.padding(5.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        AsyncImage(
                                            model = postItem.embedded.author[0].avatarUrls.size24,
                                            placeholder = painterResource(id = R.drawable.image_placeholder),
                                            error = painterResource(id = R.drawable.image_placeholder),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(24.dp)
                                                .clip(shape = CircleShape)
                                        )
                                        Text(
                                            text = postItem.embedded.author[0].name,
                                            style = MaterialTheme.typography.labelSmall
                                        )
                                    }
                                }
                            }

                        }


                        if (index==itemCount-3 && viewModel.currentPage<viewModel.totalPages){
                            viewModel.currentPage++
                            viewModel.getAllShortPosts(pageNumber = viewModel.currentPage)
                        }
                    }
                }

            }

            is RequestState.Loading -> {
                LoadingScreen()
            }
            is RequestState.Error -> {
                Text(text = "${viewModel.requestState.value.message}")
            }
            else -> {
                Text(text = "I'm idle")
            }
        }
    }
}

