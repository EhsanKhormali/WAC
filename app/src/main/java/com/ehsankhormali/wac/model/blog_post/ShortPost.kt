/**
 * this is a shortened class for displaying posts
 * in home page and doesn't contain full content of post.
 *
 * @author [ehsan khormali](https://github.com/EhsanKhormali)
 *
 */

package com.ehsankhormali.wac.model.blog_post

import com.google.gson.annotations.SerializedName

data class ShortPost(
    @SerializedName("_embedded")
    val embedded: PostEmbeddedItems,
    @SerializedName("_links")
    val links: PostLinks,
    val author: Int,
    val date: String,
    @SerializedName("date_gmt")
    val dateGmt: String,
    val excerpt: RenderedContent,
    val id: Int,
    val modified: String,
    @SerializedName("modified_gmt")
    val modifiedGmt: String,
    val tags: List<Any>,
    val template: String,
    val title: RenderedString,
    val type: String
)