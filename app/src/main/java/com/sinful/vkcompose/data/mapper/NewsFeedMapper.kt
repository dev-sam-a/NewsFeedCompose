package com.sinful.vkcompose.data.mapper

import com.sinful.vkcompose.data.model.NewsItemsResponseDto
import com.sinful.vkcompose.domain.FeedPost
import com.sinful.vkcompose.domain.StatisticType
import com.sinful.vkcompose.domain.StatisticItem

class NewsFeedMapper {

    fun mapNewsItemsToFeedPosts(responseDto: NewsItemsResponseDto): List<FeedPost> {
        val result = mutableListOf<FeedPost>()
        for (item in responseDto.results) {
            result.add(
                FeedPost(
                    id = item.id,
                    communityName = item.sourceName ?: "",
                    publicationDate = item.publicationDate,
                    communityImageUrl = item.sourceIconUrl,
                    contentText = item.description,
                    contentImageUrl = item.contentImageUrl,
                    statistics = listOf(
                        StatisticItem(StatisticType.LIKES, (0..1000).random()),
                        StatisticItem(StatisticType.VIEWS, (0..1000).random()),
                        StatisticItem(StatisticType.SHARES, (0..1000).random()),
                        StatisticItem(
                            StatisticType.COMMENTS,
                            if (item.keywords != null) item.keywords.count() else 0
                        )
                    )
                )
            )
        }
        return result
    }
}