package com.ehsankhormali.wac.repository

import com.ehsankhormali.wac.data.ApiRequest
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.model.Post
import com.ehsankhormali.wac.network.WordpressApi
import javax.inject.Inject

class WacRepository @Inject constructor(private val wordpressApi: WordpressApi) {
    suspend fun getAllPosts(pageNumber:Int=0):ApiRequest<ArrayList<Post>>{
        val apiRequest=ApiRequest<ArrayList<Post>>(data=null, state = RequestState.Loading())
        val response=try {
            apiRequest.data =wordpressApi.getAllPosts(pageNumber)
            if (!apiRequest.data.isNullOrEmpty()) apiRequest.state=RequestState.Success()
            apiRequest
        }catch (exception: Exception){
            apiRequest.state=RequestState.Error("${exception.message}")
            apiRequest
        }
        return response
    }
}