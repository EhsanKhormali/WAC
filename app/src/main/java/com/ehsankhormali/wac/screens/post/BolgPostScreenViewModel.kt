package com.ehsankhormali.wac.screens.post

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankhormali.wac.model.blog_post.EmbeddedPost
import com.ehsankhormali.wac.repository.WacRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BolgPostScreenViewModel @Inject constructor(
    private val wacRepository: WacRepository) : ViewModel() {
    val embeddablePostState : MutableState<EmbeddedPost?> = mutableStateOf(value = null)
    fun getPost(postId:Int) {
        viewModelScope.launch {
            embeddablePostState.value = wacRepository.getEmbeddedPost(postId = postId)
        }
    }

}