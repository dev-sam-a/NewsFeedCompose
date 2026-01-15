package com.sinful.vkcompose.domain

import com.sinful.vkcompose.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.ic_avatar_comment,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)
