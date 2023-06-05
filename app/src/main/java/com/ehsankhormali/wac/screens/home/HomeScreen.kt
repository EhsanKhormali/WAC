package com.ehsankhormali.wac.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ehsankhormali.wac.R
import com.ehsankhormali.wac.components.appbar.MainAppBar
import com.ehsankhormali.wac.components.wac_bottom_navigation.WacBottomNavigation
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.navigation.WacScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            Row{
                MainAppBar(query = "", navController = navController)
            }
        },
        bottomBar = { WacBottomNavigation(navController) }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            when (viewModel.postListState.value.state) {
                is RequestState.Success ->
                {
                    LazyColumn(){
                        items(items = viewModel.postListState.value.data.orEmpty()){postItem ->
                            Card(
                                modifier = Modifier.padding(5.dp),
                                elevation = CardDefaults.cardElevation(),
                                onClick = {navController.navigate(WacScreens.BlogPostScreen.name+"/${postItem.id}")}
                            ) {
                                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                                    Column {

                                        Row(modifier = Modifier.padding(5.dp),
                                            verticalAlignment = Alignment.CenterVertically) {
                                            AsyncImage(
                                                model = postItem.embedded.wpFeaturedMedia?.let{ it[0].mediaDetails.sizes.medium.sourceUrl},
                                                placeholder = painterResource(id = R.drawable.image_placeholder),
                                                error = painterResource(id = R.drawable.image_placeholder),
                                                contentDescription = null,
                                                modifier = Modifier.size(70.dp)
                                            )
                                            Column(modifier = Modifier.padding(8.dp)) {
                                                Text(
                                                    text = postItem.title.rendered,
                                                    style = MaterialTheme.typography.headlineSmall
                                                )
                                                Text(text = postItem.excerpt.rendered)
                                            }
                                        }
                                        Divider(thickness = 1.dp)
                                        Row(modifier = Modifier
                                            .height(45.dp)
                                            .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceAround) {
                                            IconButton(onClick = { /*TODO*/ }) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.chat_bubble_fill0_wght400_grad0_opsz48),
                                                    contentDescription ="",
                                                    modifier = Modifier.size(24.dp)
                                                )
                                                Text(text = (postItem.embedded.replies?.get(0)?.size?:0).toString(),
                                                    style = MaterialTheme.typography.labelSmall
                                                )
                                            }

                                            Row(modifier = Modifier.padding(5.dp),
                                                verticalAlignment = Alignment.CenterVertically) {
                                                AsyncImage(
                                                    model = postItem.embedded.author[0].avatarUrls.size24,
                                                    placeholder = painterResource(id = R.drawable.image_placeholder),
                                                    error = painterResource(id = R.drawable.image_placeholder),
                                                    contentDescription = null,
                                                    modifier = Modifier.size(24.dp)
                                                        .clip(shape = CircleShape)
                                                )
                                                Text(text = postItem.embedded.author[0].name,
                                                    style = MaterialTheme.typography.labelSmall)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
                is RequestState.Loading -> ScreenLoading()
                is RequestState.Error -> Text(text = "${viewModel.postListState.value.state.message}")
                else -> Text(text = "I'm idle")
            }
        }
    }



    }

@Composable
fun ScreenLoading(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}