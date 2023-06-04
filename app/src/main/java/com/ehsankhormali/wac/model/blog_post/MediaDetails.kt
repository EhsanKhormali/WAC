package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class MediaDetails(
    val file: String,
    @SerializedName("filesize")
    val fileSize: Int,
    val height: Int,
    @SerializedName("image_meta")
    val imageMeta: ImageMeta,
    val sizes: MediaSizes,
    val width: Int
)