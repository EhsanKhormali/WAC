package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class ReplyLinks(
    val author: List<EmbeddableLink>,
    val children: List<EmbeddableLink>,
    val collection: List<Link>,
    @SerializedName("in-reply-to")
    val inReplyTo: List<EmbeddableLink>,
    val self: List<Link>,
    val up: List<EmbeddableReplyUpLink>
)