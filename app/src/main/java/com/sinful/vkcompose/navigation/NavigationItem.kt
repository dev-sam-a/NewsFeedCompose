package com.sinful.vkcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.sinful.vkcompose.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {

    object Home : NavigationItem(
        screen = Screen.Home,
        titleResId = R.string.nav_item_main,
        icon = Icons.Outlined.Home
    )

    object Favourite : NavigationItem(
        screen = Screen.Favourite,
        titleResId = R.string.nav_item_favourite,
        icon = Icons.Outlined.FavoriteBorder
    )

    object Profile : NavigationItem(
        screen = Screen.Profile,
        titleResId = R.string.nav_item_profile,
        icon = Icons.Outlined.Person
    )
}