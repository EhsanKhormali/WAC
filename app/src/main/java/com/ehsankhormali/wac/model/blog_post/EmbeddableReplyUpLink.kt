package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class EmbeddableReplyUpLink(
    val embeddable: Boolean,
    val href: String,
    @SerializedName("post_type")
    val postType: String
)