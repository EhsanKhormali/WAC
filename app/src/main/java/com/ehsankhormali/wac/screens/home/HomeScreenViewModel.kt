package com.ehsankhormali.wac.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehsankhormali.wac.data.ApiRequest
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.model.blog_post.ShortPost
import com.ehsankhormali.wac.repository.WacRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val wacRepository: WacRepository):ViewModel() {
    val postListState=  mutableStateListOf<ShortPost>()
    var requestState= mutableStateOf<RequestState>(RequestState.Loading())

    init {
        getAllShortPosts(perPage=10,pageNumber = 1)
    }

    fun getAllShortPosts(perPage:Int=10,pageNumber:Int=0){
        viewModelScope.launch {
             val request =wacRepository.getAllShortPosts(perPage=perPage , pageNumber= pageNumber)
            if (request.state is RequestState.Success){
                request.data?.let { postListState.addAll(it) }
                requestState.value=RequestState.Success()
            }else{
                requestState.value=RequestState.Error(request.state.message.toString())
            }
        }
    }
}