package com.yudiz.instagram

import androidx.annotation.DrawableRes

sealed class BottomNavItem(val route: String, var label: String, @DrawableRes val icon: Int) {
    object Home : BottomNavItem("insta_home", "Home", R.drawable.ic_insta_home)
    object Explore : BottomNavItem("insta_explore", "Explore", R.drawable.ic_insta_search)
    object Reels : BottomNavItem("insta_reels", "Reels", R.drawable.ic_insta_reels)
    object Activity : BottomNavItem("insta_activity", "Activity", R.drawable.ic_insta_heart)
    object Profile : BottomNavItem("insta_profile", "Profile", R.drawable.ic_insta_profile)

    object Items {
        val items = listOf(
            Home, Explore, Reels, Activity, Profile
        )
    }
}