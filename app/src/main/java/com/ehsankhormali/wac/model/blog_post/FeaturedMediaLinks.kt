package com.ehsankhormali.wac.model.blog_post

data class FeaturedMediaLinks(
    val about: List<Link>,
    val author: List<EmbeddableLink>,
    val collection: List<Link>,
    val replies: List<EmbeddableLink>,
    val self: List<Link>
)