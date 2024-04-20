package com.ehsankhormali.wac.network

import com.ehsankhormali.wac.model.blog_post.EmbeddedPost
import com.ehsankhormali.wac.model.blog_post.ShortPost
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WordpressApi {
    @GET("posts?_embed")
    suspend fun getAllPosts(@Query("p") pageNumber:Int):ArrayList<EmbeddedPost>
    @GET("posts?_embed&_fields= id,date,date_gmt,modified,modified_gmt,title,excerpt,author,_links.replies,_links.wp:featuredmedia,_links.author,_embedded")
    suspend fun getAllShortPost(@Query("page") pageNumber:Int,@Query("per_page") perPage:Int):ArrayList<ShortPost>

    @GET("posts/{postId}?_embed")
    suspend fun getEmbeddedPost(@Path("postId") postId:Int):EmbeddedPost
}