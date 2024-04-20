package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class WpFeaturedMedia(
    @SerializedName("_links")
    val links: FeaturedMediaLinks,
    @SerializedName("alt_text")
    val altText: String,
    val author: Int,
    val caption: RenderedString,
    val date: String,
    val id: Int,
    val link: String,
    @SerializedName("media_details")
    val mediaDetails: MediaDetails?,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("mime_type")
    val mimeType: String,
    val slug: String,
    @SerializedName("source_url")
    val source_url: String,
    val title: RenderedString,
    val type: String
)