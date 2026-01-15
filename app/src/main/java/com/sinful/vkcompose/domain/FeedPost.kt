package com.sinful.vkcompose.domain

import com.sinful.vkcompose.R

data class FeedPost(
    val id: Int = 0,
    val communityNane: String = "/android/dev/hell",
    val publicationData: String = "14:00",
    val avatarResId: Int = R.drawable.clown_profile,
    val contentText: String = "Настроение на первый рабочий день в 2026: Серж Танкян на работе в офисе – за несколько лет до основания легендарной группы System of a Down",
    val contentImageResId: Int = R.drawable.vk_post,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 965),
        StatisticItem(type = StatisticType.SHARES, 7),
        StatisticItem(type = StatisticType.COMMENTS, 15),
        StatisticItem(type = StatisticType.LIKES, 26),
    )
)