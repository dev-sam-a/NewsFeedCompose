package com.sinful.vkcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinful.vkcompose.domain.FeedPost
import com.sinful.vkcompose.domain.PostComment
import com.sinful.vkcompose.ui.theme.CommentsScreenState

class CommentsViewModel : ViewModel() {

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState

    init {
        loadComments(FeedPost())
    }

    fun loadComments(feedPost: FeedPost) {
        val comments = mutableListOf<PostComment>().apply {
            repeat(10) {
                add(PostComment(it))
            }
        }
        _screenState.value = CommentsScreenState.Comments(feedPost, comments)
    }

}