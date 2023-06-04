package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class WpTerm(
    @SerializedName("_links")
    val links: WpTermLinks,
    val id: Int,
    val link: String,
    val name: String,
    val slug: String,
    val taxonomy: String
)