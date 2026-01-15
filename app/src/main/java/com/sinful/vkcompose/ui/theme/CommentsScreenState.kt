package com.sinful.vkcompose.ui.theme

import com.sinful.vkcompose.domain.FeedPost
import com.sinful.vkcompose.domain.PostComment

sealed class CommentsScreenState {

    object Initial: CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ): CommentsScreenState()
}