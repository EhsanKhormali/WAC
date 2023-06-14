package com.ehsankhormali.wac.screens.post

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankhormali.wac.data.ApiRequest
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.model.blog_post.EmbeddedPost
import com.ehsankhormali.wac.repository.WacRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BolgPostScreenViewModel @Inject constructor(
    private val wacRepository: WacRepository
) : ViewModel() {
    val embeddablePostStateApiRequest: MutableState<ApiRequest<EmbeddedPost>> =
        mutableStateOf(
            ApiRequest(data = null, state = RequestState.Loading())
        )

    fun getPost(postId: Int) {
        viewModelScope.launch {

            embeddablePostStateApiRequest.value = wacRepository.getEmbeddedPost(postId = postId)
        }
    }

}