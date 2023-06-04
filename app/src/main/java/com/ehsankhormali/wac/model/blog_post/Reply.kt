package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class Reply(
    @SerializedName("_links")
    val links: ReplyLinks,
    val author: Int,
    @SerializedName("author_avatar_urls")
    val authorAvatarUrls: AvatarUrls,
    @SerializedName("author_name")
    val authorName: String,
    @SerializedName("author_url")
    val authorUrl: String,
    val content: RenderedString,
    val date: String,
    val id: Int,
    val link: String,
    val parent: Int,
    val type: String
)