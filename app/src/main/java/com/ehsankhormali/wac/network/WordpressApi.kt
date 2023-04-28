package com.ehsankhormali.wac.network

import com.ehsankhormali.wac.model.Post
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WordpressApi {
    @GET("posts?_fields=id,author,date,date_gmt,modified,modified_gmt,slug,status,type,title,content,excerpt,featured_media,comment_status,ping_status,sticky,template,format,meta,categories,tags")
    suspend fun getAllPosts(@Query("p") pageNumber:Int):ArrayList<Post>
}