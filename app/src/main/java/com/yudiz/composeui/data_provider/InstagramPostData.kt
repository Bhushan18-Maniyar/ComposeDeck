package com.yudiz.composeui.data_provider

import androidx.annotation.DrawableRes
import com.yudiz.composeui.R

data class InstagramPostData(
    val id: Int,
    val author: String,
    @DrawableRes val painter: Int,
    val caption: String,
    val time: String,
    @DrawableRes val authorImage: Int,
    val authorHasStory: Boolean,
    val likedBy: List<User> = emptyList()
)

data class User(
    val id: Int = 0,

)

val instaPostList = listOf(
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImage = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
)