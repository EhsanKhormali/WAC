package com.ehsankhormali.wac.model

import com.ehsankhormali.wac.model.blog_post.AuthorLinks
import com.ehsankhormali.wac.model.blog_post.AvatarUrls
import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("_links")
    val links: AuthorLinks,
    @SerializedName("avatar_urls")
    val avatarUrls: AvatarUrls,
    val description: String,
    val id: Int,
    val link: String,
    val name: String,
    val slug: String,
    val url: String
)