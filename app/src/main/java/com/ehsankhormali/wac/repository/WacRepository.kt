package com.ehsankhormali.wac.repository

import com.ehsankhormali.wac.data.ApiRequest
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.model.blog_post.EmbeddedPost
import com.ehsankhormali.wac.model.blog_post.ShortPost
import com.ehsankhormali.wac.network.WordpressApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WacRepository @Inject constructor(private val wordpressApi: WordpressApi) {
    suspend fun getAllPosts(pageNumber:Int=0):ApiRequest<ArrayList<EmbeddedPost>>{
        val apiRequest=ApiRequest<ArrayList<EmbeddedPost>>(data=null, state = RequestState.Loading())
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

    suspend fun getAllShortPosts(perPage:Int=10,pageNumber:Int=0):ApiRequest<ArrayList<ShortPost>>{
        val apiRequest=ApiRequest<ArrayList<ShortPost>>(data=null, state = RequestState.Loading())
        val posts:Flow<ArrayList<ShortPost>> = flow {
            try {
                val requestedPosts =
                    wordpressApi.getAllShortPost(perPage = perPage, pageNumber = pageNumber)
                apiRequest.state=RequestState.Success()
                emit(requestedPosts)
            }catch (exception:Exception){
                apiRequest.state=RequestState.Error(exception.message.toString())
            }
        }
        posts.collect{
            apiRequest.data=it
        }

        /*val response=try {
            apiRequest.data =wordpressApi.getAllShortPost(perPage = perPage, pageNumber = pageNumber)
            if (!apiRequest.data.isNullOrEmpty()) apiRequest.state=RequestState.Success()
            apiRequest
        }catch (exception: Exception){
            apiRequest.state=RequestState.Error("${exception.message}")
            apiRequest
        }
        return response
        */
        return apiRequest
    }

    suspend fun getEmbeddedPost(postId:Int) : ApiRequest<EmbeddedPost>{
        val apiRequest=ApiRequest<EmbeddedPost>(data = null, state = RequestState.Loading())
        val response=try {
            apiRequest.data=wordpressApi.getEmbeddedPost(postId = postId)
            apiRequest.state=RequestState.Success()
            apiRequest
        }catch (exception:Exception){
            apiRequest.state=RequestState.Error("${exception.message}")
            apiRequest
        }
        return response
    }
}