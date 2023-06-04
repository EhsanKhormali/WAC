package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class MediaSize(
    @SerializedName("file")
    val fileName: String,
    val height: Int,
    @SerializedName("mime_type")
    val mimeType: String,
    @SerializedName("source_url")
    val sourceUrl: String,
    val width: Int,
    @SerializedName("filesize")
    val fileSize: Int?
)