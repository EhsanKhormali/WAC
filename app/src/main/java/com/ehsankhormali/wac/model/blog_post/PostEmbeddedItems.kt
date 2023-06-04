package com.ehsankhormali.wac.model.blog_post

import com.ehsankhormali.wac.model.Author
import com.google.gson.annotations.SerializedName

data class PostEmbeddedItems(
    val author: List<Author>,
    val replies: List<List<Reply>>?,
    @SerializedName("wp:featuredmedia")
    val wpFeaturedMedia: List<WpFeaturedMedia>?,
    @SerializedName("wp:term")
    val Term: List<List<WpTerm>>
)