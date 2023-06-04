package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class AvatarUrls(
    @SerializedName("24")
    val size24: String,
    @SerializedName("48")
    val size48: String,
    @SerializedName("96")
    val size96: String
)