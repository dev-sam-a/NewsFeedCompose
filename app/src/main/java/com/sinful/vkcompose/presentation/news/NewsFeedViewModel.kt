package com.sinful.vkcompose.presentation.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinful.vkcompose.data.mapper.NewsFeedMapper
import com.sinful.vkcompose.data.network.ApiFactory
import com.sinful.vkcompose.domain.FeedPost
import com.sinful.vkcompose.domain.StatisticItem
import kotlinx.coroutines.launch

class NewsFeedViewModel : ViewModel() {


    private val initialState = NewsFeedScreenState.Initial

    private val _screenState = MutableLiveData<NewsFeedScreenState>(initialState)
    val screenState: LiveData<NewsFeedScreenState> = _screenState

    private val mapper = NewsFeedMapper()

    private val newsDataAccessToken = "pub_92832bfacb1243d9b8857e60345a971c"

    init {
        loadNews()
    }

    private fun loadNews(){
        viewModelScope.launch {
            val response = ApiFactory.apiService.loadNews(newsDataAccessToken, "it technology")
            val feedPosts = mapper.mapNewsItemsToFeedPosts(response)
            _screenState.value = NewsFeedScreenState.Posts(feedPosts)
        }
    }

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = NewsFeedScreenState.Posts(newPosts)

    }

    fun remove(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPost = currentState.posts.toMutableList()
        oldPost.remove(feedPost)
        _screenState.value = NewsFeedScreenState.Posts(oldPost)
    }
}