package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class WpTermLinks(
    val about: List<Link>,
    val collection: List<Link>,
    val curies: List<CuriesLink>,
    val self: List<Link>,
    val up: List<EmbeddableLink>,
    @SerializedName("wp:post_type")
    val wpPostType: List<Link>
)