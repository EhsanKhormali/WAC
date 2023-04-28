package com.ehsankhormali.wac.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankhormali.wac.data.ApiRequest
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.model.Post
import com.ehsankhormali.wac.repository.WacRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val wacRepository: WacRepository):ViewModel() {
    val postListState:MutableState<ApiRequest<ArrayList<Post>>> = mutableStateOf(ApiRequest(data = null, state = RequestState.Idle()))

    init {
        getAllPosts()
    }

    private fun getAllPosts(pageNumber:Int=0){
        viewModelScope.launch {
            postListState.value.state=RequestState.Loading()
            postListState.value=wacRepository.getAllPosts(pageNumber=pageNumber)
            if (!postListState.value.data.isNullOrEmpty())postListState.value.state=RequestState.Success()
        }
    }
}