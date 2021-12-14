package com.yudiz.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import com.yudiz.dataprovider.data_provider.instaPostList
import com.yudiz.instagram.components.InstaPosts
import com.yudiz.instagram.components.InstaStory
import com.yudiz.instagram.components.RoundedProfilePic

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
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RoundedProfilePic(
                            modifier = Modifier.size(storySize)
                        )
                        Spacer(modifier = Modifier.height(1.dp))
                        Text("Your Story", color = Color.White)
                    }
                }
                items(items = instaPostList) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        InstaStory(
                            profilePic = rememberGlidePainter(it.painter),
                            modifier = Modifier.size(storySize)
                        )
                        Spacer(modifier = Modifier.height(1.dp))
                        Text(
                            text = it.author,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 1.dp)
                                .width(60.dp),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
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