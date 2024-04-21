package com.ehsankhormali.wac.repository

import com.ehsankhormali.wac.data.ApiPostRequest
import com.ehsankhormali.wac.data.ApiRequest
import com.ehsankhormali.wac.data.RequestState
import com.ehsankhormali.wac.model.blog_post.EmbeddedPost
import com.ehsankhormali.wac.model.blog_post.ShortPost
import com.ehsankhormali.wac.network.WordpressApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class WacRepository @Inject constructor(private val wordpressApi: WordpressApi) {
   /* suspend fun getAllPosts(pageNumber:Int=0):ApiPostRequest<ArrayList<EmbeddedPost>>{
        val apiRequest=ApiPostRequest<ArrayList<EmbeddedPost>>(data=null, state = RequestState.Loading())
        val response=try {
            apiRequest.data =wordpressApi.getAllPosts(pageNumber)
            if (!apiRequest.data.isNullOrEmpty()) apiRequest.state=RequestState.Success()
            apiRequest
        }catch (exception: Exception){
            apiRequest.state=RequestState.Error("${exception.message}")
            apiRequest
        }
        return response
    }*/

    suspend fun getAllShortPosts(perPage:Int=10,pageNumber:Int=0):ApiPostRequest<ArrayList<ShortPost>>{
        val apiRequest=ApiPostRequest<ArrayList<ShortPost>>(data=null, state = RequestState.Loading(), total = 0, totalPages = 0)
        val call= wordpressApi.getAllShortPost(perPage = perPage, pageNumber = pageNumber)
        val posts:Flow<Response<ArrayList<ShortPost>>?> = flow {
            try {
                val response=call.awaitResponse()
                apiRequest.state=RequestState.Success()
                emit(response)
            }catch (exception:Exception){
                apiRequest.state=RequestState.Error(exception.message.toString())
            }
        }
        posts.collect{
            if (it != null) {
                apiRequest.total= it.headers()["x-wp-total"]?.toInt()?:0
                apiRequest.data=it.body()
                apiRequest.totalPages= it.headers()["x-wp-totalpages"]?.toInt()?:0
            }

        }
        /*val posts:Flow<ArrayList<ShortPost>> = flow {
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
        }*/
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