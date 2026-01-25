package com.sinful.vkcompose.data.model

import com.google.gson.annotations.SerializedName

data class NewsItemsResponseDto (
    val results: List<NewsItemDto>
)

data class NewsItemDto(
    @SerializedName("article_id") val id: String,
    @SerializedName("source_name") val sourceName: String?,
    @SerializedName("pubDate") val publicationDate: String,
    @SerializedName("source_icon") val sourceIconUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val contentImageUrl: String?,
    val keywords: List<String>? // keywords я буду использовать вместо комментариев
)