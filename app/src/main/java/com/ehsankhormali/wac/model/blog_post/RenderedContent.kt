package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class RenderedContent(
    @SerializedName("`protected`")
    val protected: Boolean,
    val rendered: String
)