package com.yudiz.instagram

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import com.yudiz.dataprovider.data_provider.instaPostList
import com.yudiz.instagram.components.*

@Composable
fun InstaHomePage() {
    val storySize = 70.dp
    LazyColumn(
        modifier = Modifier.background(Color.Black),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    RoundedProfilePic(
                        modifier = Modifier.size(storySize)
                    )
                }
                items(items = instaPostList) {
                    InstaStory(
                        profilePic = rememberGlidePainter(it.painter),
                        modifier = Modifier.size(storySize)
                    )
                }
            }
        }

        items(items = instaPostList) { postItem ->
            InstaPosts(data = postItem)
        }
    }

}


@Preview
@Composable
fun InstaHomePagePreview() {
    InstaHomePage()
}