package com.yudiz.instagram.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import com.yudiz.dataprovider.data_provider.InstagramPostData
import com.yudiz.instagram.R
import kotlinx.coroutines.delay
import com.yudiz.dataprovider.R as RR


@Composable
fun RoundedProfilePic(
    modifier: Modifier = Modifier,
    profilePic: Painter = painterResource(RR.drawable.mark_zuckerberg_profile)
) {
    Image(
        modifier = modifier
            .clip(CircleShape),
        painter = profilePic,
        contentDescription = "Story",
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun RoundedCornerProfilePicPreview() {
    RoundedProfilePic(modifier = Modifier.size(120.dp))
}


@Composable
fun InstaStory(
    modifier: Modifier = Modifier,
    profilePic: Painter = painterResource(id = RR.drawable.sundar_pichai_profile)
) {
    Box(
        modifier = modifier
            .sizeIn(60.dp, 60.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFF9AA1B),
                        Color(0xFFF76E12),
                        Color(0xFFE95D3A),
                        Color(0xFFC20998),
                        Color(0xFFC6078B),
                        Color(0xFFF9AA1B),
                    ).reversed()
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.8.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .padding(1.5.dp)
                .clip(CircleShape),
            painter = profilePic,
            contentDescription = "Story",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun InstaStoryPreview() {
    InstaStory(
        modifier = Modifier.size(120.dp),
        profilePic = painterResource(R.drawable.sundar_pichai_profile)
    )
}


@Composable
fun InstaHomeScreenTopBar(
    modifier: Modifier = Modifier,
    addPostClick: () -> Unit,
    messagesClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        elevation = 8.dp,
        backgroundColor = Color.Black
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_insta_text),
                    contentDescription = "Instagram",
                    colorFilter = ColorFilter.tint(color = Color.White),
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .padding(end = 8.dp)
                ) {
                    IconButton(onClick = addPostClick) {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(R.drawable.ic_insta_add_post),
                            contentDescription = "Add Post",
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    }


                    IconButton(onClick = messagesClick) {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(R.drawable.ic_insta_messenger),
                            contentDescription = "Messages",
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun InstaHomeScreenTopBarPreview() {
    InstaHomeScreenTopBar(modifier = Modifier, {}, {})
}


@Composable
fun InstaPosts(
    modifier: Modifier = Modifier,
    data: InstagramPostData
) {
    var isLiked by remember(data.id) {
        mutableStateOf(false)
    }
    var isBookmarked by remember(data.id) {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (data.authorHasStory) {
                    InstaStory(
                        profilePic = rememberGlidePainter(data.painter),
                        modifier = Modifier.size(35.dp)
                    )
                } else {
                    RoundedProfilePic(
                        profilePic = rememberGlidePainter(data.painter),
                        modifier = Modifier.size(35.dp)
                    )
                }
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    text = data.author,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .padding(end = 0.dp),
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = "Menu",
                tint = Color.White,
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = {
                                isLiked = true
                            }
                        )
                    },
                painter = rememberGlidePainter(data.authorImageId),
                contentDescription = "Post",
                contentScale = ContentScale.Crop
            )
            DoubleTapHeartLikeAnimation(isLiked, modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 6.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { isLiked = !isLiked },
            ) {
                Icon(
                    imageVector = if (isLiked) {
                        Icons.Filled.Favorite
                    } else {
                        Icons.Outlined.FavoriteBorder
                    },
                    contentDescription = "Like",
                    tint = if (isLiked) Color.Red else Color.White,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            isLiked = !isLiked
                        }
                )
            }

            IconButton(
                onClick = { },
            ) {
                Image(
                    painter = rememberGlidePainter(R.drawable.ic_insta_comment),
                    contentDescription = "Comment",
                    modifier = Modifier.size(36.dp),
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }

            IconButton(
                onClick = { },
            ) {
                Image(
                    painter = rememberGlidePainter(R.drawable.ic_insta_send),
                    contentDescription = "Send",
                    colorFilter = ColorFilter.tint(color = Color.White),
                    modifier = Modifier.size(22.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = { isBookmarked = !isBookmarked },
                ) {
                    Image(
                        painter = if (isBookmarked) {
                            rememberGlidePainter(R.drawable.ic_insta_bookmarked_fillded)
                        } else {
                            rememberGlidePainter(R.drawable.ic_insta_bookmarked_outlined)
                        },
                        contentDescription = "Like",
                        colorFilter = ColorFilter.tint(color = Color.White),
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                isBookmarked = !isBookmarked
                            }
                    )
                }
            }
        }

        Row(
            modifier = Modifier.padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundedProfilePic(
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = buildAnnotatedString {
                    append("Liked by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Mark Zukerberg, Elon Musk")
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("12,12,123 others")
                    }
                },
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        // if caption is there
        if (data.caption.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(data.author)
                    }
                    append(" ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(data.caption)
                    }
                },
                color = Color.White,
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 2.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            text = "View all 140000 Comments",
            color = Color.LightGray,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 2.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = data.time,
            color = Color.LightGray,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 0.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Composable
fun DoubleTapHeartLikeAnimation(
    isLike: Boolean = false,
    modifier: Modifier = Modifier
) {
    var removeLikeIcon by remember {
        mutableStateOf(false)
    }
    if (isLike) {
        LaunchedEffect(key1 = removeLikeIcon, block = {
            delay(1000)
            removeLikeIcon = true
        })
    }
    val animatedSize by animateDpAsState(
        targetValue = if (isLike) 80.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = 500f
        )
    )
    AnimatedVisibility(visible = !removeLikeIcon) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            modifier = modifier.size(animatedSize),
            contentDescription = "Like",
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun DoubleTapHeartLikeAnimationPreview() {
    DoubleTapHeartLikeAnimation(true)
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun InstaPostsPreview() {
    InstaPosts(
        data = InstagramPostData(
            id = 1,
            painter = R.drawable.sundar_pichai_profile,
            author = "Sundar Pichai",
            authorHasStory = false,
            authorImageId = R.drawable.sundar_pichai_profile,
            caption = "Wear your failures as a badge of honor.",
            time = "15 Minutes Ago"
        )
    )
}


@Composable
fun ProfileStoryHighlight(
    painter: Painter = painterResource(id = R.drawable.elon_musk_profile),
    highlightedText: String = "Highlights",
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .sizeIn(60.dp, 60.dp)
                .clip(CircleShape)
                .background(
                    color = Color.Gray
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.8.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(1.5.dp)
                    .clip(CircleShape),
                painter = painter,
                contentDescription = "Story",
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = highlightedText,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 1.dp)
                .width(50.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun ProfileStoryHighlightPreview() {
    ProfileStoryHighlight(
        modifier = Modifier.size(120.dp)
    )
}

@Composable
fun InstaOutlinedButton(
    text: String? = null,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        modifier = modifier,
        onClick = { },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
    ) {
        text?.let {
            Text(
                it,
                color = Color.White,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(0.dp)
            )
        }
        icon?.let {
            Image(
                imageVector = it,
                contentDescription = "$text",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Preview
@Composable
fun InstaOutlinedButtonPreview() {
    Column() {
        InstaOutlinedButton(
            text = "Edit Profile",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(22.dp))
        InstaOutlinedButton(
            icon = Icons.Default.KeyboardArrowDown
        )
    }
}


@Composable
fun InstaProfileTopBar(
    isProfilePrivate: Boolean = false,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Color.Black
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isProfilePrivate) {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "Private Profile",
                        tint = Color.White
                    )
                }
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        ) {
                            append("zuck")
                        }
                    },
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 8.dp)
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(R.drawable.ic_insta_add_post),
                    contentDescription = "Add Post",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )

                Spacer(modifier = Modifier.width(24.dp))

                Image(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "Menu",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }
        }
    }
}

@Preview
@Composable
fun InstaProfileTopBarPreview() {
    InstaProfileTopBar()
}
