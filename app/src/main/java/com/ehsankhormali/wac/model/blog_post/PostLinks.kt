package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class PostLinks(
    val about: List<Link>,
    val author: List<EmbeddableLink>,
    val collection: List<Link>,
    val curies: List<CuriesLink>,
    @SerializedName("predecessor-version")
    val predecessorVersion: List<PredecessorVersionLink>,
    val replies: List<EmbeddableLink>,
    val self: List<Link>,
    @SerializedName("version-history")
    val versionHistory: List<VersionHistoryLink>,
    @SerializedName("wp:attachment")
    val wpAttachment: List<Link>,
    @SerializedName("wp:featuredmedia")
    val wpFeaturedMedia: List<EmbeddableLink>?,
    @SerializedName("wp:term")
    val wpTerm: List<WpPostTermLink>
)