package com.yudiz.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.yudiz.composeui.data_provider.InstagramPostData
import com.yudiz.instagram.BottomNavItem.Items.items

@Composable
fun InstaHomePage(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { InstaTopBar() },
        bottomBar = {

        }
    ) {

    }
}

@Composable
fun Posts(
    modifier: Modifier = Modifier,
//    data: InstagramPostData
) {

}

@Composable
fun InstaTopBar(modifier: Modifier = Modifier) {
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
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_insta_text),
                    contentDescription = "Instagram",
                    colorFilter = ColorFilter.tint(color = Color.White),
                    modifier = Modifier.padding(4.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_insta_add_post),
                        contentDescription = "Add Post",
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )

                    Spacer(modifier = Modifier.width(26.dp))

                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_insta_messenger),
                        contentDescription = "Messages",
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun InstaTopBarPreview() {
    InstaTopBar()
}

@Composable
fun InstaBottomBar(
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        backgroundColor = Color.Black,
        elevation = 8.dp,
        modifier = modifier,
    ) {
        items.forEach {
            BottomNavigationItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.label
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun InstaBottomBarPreview() {
    InstaBottomBar()
}
