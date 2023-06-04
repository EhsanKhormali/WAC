package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class EmbeddedPost(
    @SerializedName("_embedded")
    val embedded: PostEmbeddedItems,
    @SerializedName("_links")
    val links: PostLinks,
    val author: Int,
    val categories: List<Int>,
    @SerializedName("comment_status")
    val commentStatus: String,
    val content: RenderedContent,
    val date: String,
    @SerializedName("date_gmt")
    val dateGmt: String,
    val excerpt: RenderedContent,
    @SerializedName("featured_media")
    val featuredMedia: Int,
    val format: String,
    val guid: RenderedString,
    val id: Int,
    val link: String,
    val meta: List<Any>,
    val modified: String,
    @SerializedName("modified_gmt")
    val modifiedGmt: String,
    @SerializedName("ping_status")
    val pingStatus: String,
    val slug: String,
    val status: String,
    val sticky: Boolean,
    val tags: List<Any>,
    val template: String,
    val title: RenderedString,
    val type: String
)