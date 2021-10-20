package com.yudiz.instagram

import android.os.Build
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import com.yudiz.composeui.data_provider.instaPostList
import com.yudiz.instagram.components.InstaOutlinedButton
import com.yudiz.instagram.components.ProfileStoryHighlight
import com.yudiz.instagram.components.RoundedProfilePic
import java.lang.Float.min


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InstaProfilePage(
    modifier: Modifier = Modifier
) {

    val scrollState = rememberLazyListState()

    Column(
        modifier = modifier.background(Color.Black)
    ) {

        val scrollOffset: Float = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            min(
                1f,
                1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)
            )
        } else {
            1.0f
        }

        InstaTopSection(scrollOffset)

        GridPosts(
            scrollState = scrollState
        )
    }

}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun InstaTopSection(
    scrollOffset: Float,
    modifier: Modifier = Modifier
) {
    Log.e("TAG OFFSET", "InstaTopSection: $scrollOffset")
    AnimatedVisibility(
        visible = scrollOffset == 1.0f,
        exit = shrinkVertically(),
        enter = expandVertically(),
    ) {
        Column(
            modifier = modifier.onGloballyPositioned {
                it.boundsInWindow().height
            }
        ) {
            ProfileTopSection(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 12.dp),
            )
            Column(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 12.dp)
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "Mark Zuckerberg",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 14.sp,
                            )
                        ) {
                            append(
                                "Mark Elliot Zuckerberg is an American media magnate, " +
                                        "internet entrepreneur, and philanthropist. " +
                                        "He is known for co-founding Facebook and serves as its chairman, " +
                                        "chief executive officer, and controlling shareholder"
                            )
                        }
                    },
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InstaOutlinedButton(
                        text = "Edit Profile",
                        modifier = Modifier
                            .weight(2f, true)
                    )
                    InstaOutlinedButton(
                        icon = Icons.Default.KeyboardArrowDown,
                        modifier = Modifier
                            .weight(0.5f, true)
                            .padding(start = 8.dp)
                    )
                }
            }


            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                items(items = instaPostList) { postItem ->
                    ProfileStoryHighlight(
                        modifier = Modifier.size(60.dp),
                        painter = painterResource(id = postItem.authorImage),
                        highlightedText = postItem.author
                    )
                }
            }
        }
    }
    ProfileTabs(
        onTabSelected = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = if (scrollOffset != 1.0f) 0.dp else 12.dp, bottom = 2.dp)
    )
}


@Preview
@Composable
fun InstaProfilePagePreview() {
    InstaProfilePage()
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridPosts(
    scrollState: LazyListState,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier
            .scale(1.01f),
        state = scrollState
    ) {
        items(items = (1..30).toList()) {
            Image(
                painter = painterResource(id = R.drawable.mark_zuckerberg_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.Black
                    )
            )
        }
    }
}

@Composable
fun ProfileTabs(
    onTabSelected: (selectedIndex: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        backgroundColor = Color.Transparent
    ) {
        Tab(
            selected = selectedTabIndex == 0, onClick = {
                selectedTabIndex = 0
                onTabSelected.invoke(0)
            },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.LightGray,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_grid),
                    contentDescription = "Posts",
                    modifier = Modifier.size(25.dp)
                )
            }
        )
        Tab(
            selected = selectedTabIndex == 1, onClick = {
                selectedTabIndex = 1
                onTabSelected.invoke(1)
            },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.LightGray,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_insta_reels),
                    contentDescription = "Posts",
                    modifier = Modifier.size(25.dp)
                )
            }
        )
        Tab(
            selected = selectedTabIndex == 2, onClick = {
                selectedTabIndex = 2
                onTabSelected.invoke(2)
            },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.LightGray,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_insta_profile),
                    contentDescription = "Posts",
                    modifier = Modifier.size(25.dp)
                )
            }
        )
    }
}

@Preview
@Composable
fun ProfileTabsPreview() {
    ProfileTabs(onTabSelected = {

    }, modifier = Modifier.fillMaxWidth())
}

@Composable
fun ProfileTopSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RoundedProfilePic(
            modifier = Modifier.size(90.dp),
            profilePic = painterResource(id = R.drawable.mark_zuckerberg_profile)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InstaProfileDetail(count = "190", detail = "Post")

            InstaProfileDetail(count = "8.5M", detail = "Followers")

            InstaProfileDetail(count = "405", detail = "Following")
        }
    }
}

@Composable
fun InstaProfileDetail(
    count: String,
    detail: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            fontSize = 22.sp,
            fontWeight = FontWeight.W700,
            color = Color.White,
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = detail,
            fontSize = 14.sp,
            color = Color.White,
        )
    }
}

@Preview
@Composable
fun InstaProfileDetailPreview() {
    InstaProfileDetail(count = "22", detail = "Following")
}

@Preview
@Composable
fun ProfileTopSectionPreview() {
    ProfileTopSection()
}
