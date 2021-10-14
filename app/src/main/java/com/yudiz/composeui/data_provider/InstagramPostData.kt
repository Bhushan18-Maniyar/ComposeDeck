package com.yudiz.composeui.data_provider

import androidx.annotation.DrawableRes

data class InstagramPostData(
    val id: Int,
    val author: String,
    @DrawableRes val painter: Int,
    val caption: String,
    val time: String,
    @DrawableRes val authorImage: Int,
    val authorHasStory: Boolean
)

val instaPostList = listOf<InstagramPostData>(

)