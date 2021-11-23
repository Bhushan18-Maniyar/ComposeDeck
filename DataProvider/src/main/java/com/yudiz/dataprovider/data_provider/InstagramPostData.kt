package com.yudiz.dataprovider.data_provider

import androidx.annotation.DrawableRes
import com.yudiz.dataprovider.R

data class InstagramPostData(
    val id: Int,
    val author: String,
    @DrawableRes val painter: Int,
    val caption: String,
    val time: String,
    @DrawableRes val authorImageId: Int,
    val authorHasStory: Boolean,
    val likedBy: List<User> = emptyList(),
    var isLiked: Boolean = false
)

data class User(
    val id: Int = 0,
)

val instaPostList = listOf(
    InstagramPostData(
        id = 1,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = true,
        authorImageId = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 2,
        painter = R.drawable.mark_zuckerberg_profile,
        author = "Mark Zukerberg",
        authorHasStory = false,
        authorImageId = R.drawable.mark_zuckerberg_profile,
        caption = "Facebook was not originally created to be a company. It was built to accomplish a social mission - to make the world more open and connected.",
        time = "20 Minutes Ago"
    ),
    InstagramPostData(
        id = 3,
        painter = R.drawable.elon_musk_profile,
        author = "Elon Musk",
        authorHasStory = false,
        authorImageId = R.drawable.elon_musk_profile,
        caption = "When something is important enough, you do it even if the odds are not in your favor.",
        time = "30 Minutes Ago"
    ),
    InstagramPostData(
        id = 4,
        painter = R.drawable.satya_nadella_profile,
        author = "Satya Nadella",
        authorHasStory = true,
        authorImageId = R.drawable.satya_nadella_profile,
        caption = "In our business, things look like a failure until they're not. It's pretty binary transitions.",
        time = "45 Minutes Ago"
    ),
    InstagramPostData(
        id = 5,
        painter = R.drawable.jeff_bazos_profile,
        author = "Jeff Bazos",
        authorHasStory = false,
        authorImageId = R.drawable.jeff_bazos_profile,
        caption = "I believe you have to be willing to be misunderstood if you’re going to innovate.",
        time = "38 Minutes Ago"
    ),
    InstagramPostData(
        id = 6,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = true,
        authorImageId = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 7,
        painter = R.drawable.mark_zuckerberg_profile,
        author = "Mark Zukerberg",
        authorHasStory = false,
        authorImageId = R.drawable.mark_zuckerberg_profile,
        caption = "Facebook was not originally created to be a company. It was built to accomplish a social mission - to make the world more open and connected.",
        time = "20 Minutes Ago"
    ),
    InstagramPostData(
        id = 8,
        painter = R.drawable.elon_musk_profile,
        author = "Elon Musk",
        authorHasStory = false,
        authorImageId = R.drawable.elon_musk_profile,
        caption = "When something is important enough, you do it even if the odds are not in your favor.",
        time = "30 Minutes Ago"
    ),
    InstagramPostData(
        id = 9,
        painter = R.drawable.satya_nadella_profile,
        author = "Satya Nadella",
        authorHasStory = true,
        authorImageId = R.drawable.satya_nadella_profile,
        caption = "In our business, things look like a failure until they're not. It's pretty binary transitions.",
        time = "45 Minutes Ago"
    ),
    InstagramPostData(
        id = 10,
        painter = R.drawable.jeff_bazos_profile,
        author = "Jeff Bazos",
        authorHasStory = false,
        authorImageId = R.drawable.jeff_bazos_profile,
        caption = "I believe you have to be willing to be misunderstood if you’re going to innovate.",
        time = "38 Minutes Ago"
    ),
    InstagramPostData(
        id = 11,
        painter = R.drawable.sundar_pichai_profile,
        author = "Sundar Pichai",
        authorHasStory = false,
        authorImageId = R.drawable.sundar_pichai_profile,
        caption = "Wear your failures as a badge of honor.",
        time = "15 Minutes Ago"
    ),
    InstagramPostData(
        id = 12,
        painter = R.drawable.mark_zuckerberg_profile,
        author = "Mark Zukerberg",
        authorHasStory = false,
        authorImageId = R.drawable.mark_zuckerberg_profile,
        caption = "Facebook was not originally created to be a company. It was built to accomplish a social mission - to make the world more open and connected.",
        time = "20 Minutes Ago"
    ),
    InstagramPostData(
        id = 13,
        painter = R.drawable.elon_musk_profile,
        author = "Elon Musk",
        authorHasStory = false,
        authorImageId = R.drawable.elon_musk_profile,
        caption = "When something is important enough, you do it even if the odds are not in your favor.",
        time = "30 Minutes Ago"
    ),
    InstagramPostData(
        id = 14,
        painter = R.drawable.satya_nadella_profile,
        author = "Satya Nadella",
        authorHasStory = true,
        authorImageId = R.drawable.satya_nadella_profile,
        caption = "In our business, things look like a failure until they're not. It's pretty binary transitions.",
        time = "45 Minutes Ago"
    ),
    InstagramPostData(
        id = 15,
        painter = R.drawable.jeff_bazos_profile,
        author = "Jeff Bazos",
        authorHasStory = false,
        authorImageId = R.drawable.jeff_bazos_profile,
        caption = "I believe you have to be willing to be misunderstood if you’re going to innovate.",
        time = "38 Minutes Ago"
    ),
)