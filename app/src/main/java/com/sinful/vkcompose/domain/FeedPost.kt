package com.sinful.vkcompose.domain

import android.os.Parcelable
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.google.gson.Gson
import com.sinful.vkcompose.R
import kotlinx.parcelize.Parcelize

@Parcelize
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
) : Parcelable {

    companion object {

        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {
            override fun put(bundle: SavedState, key: String, value: FeedPost) {
                bundle.putParcelable(key, value)
            }

            override fun get(bundle: SavedState, key: String): FeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson(value, FeedPost::class.java)
            }

        }
    }
}