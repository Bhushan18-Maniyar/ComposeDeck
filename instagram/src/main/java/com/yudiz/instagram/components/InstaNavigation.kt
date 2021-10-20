package com.yudiz.instagram.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yudiz.instagram.BottomNavItem
import com.yudiz.instagram.InstaHomePage
import com.yudiz.instagram.InstaProfilePage


@Composable
fun InstaNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val currentInstaScreen = BottomNavItem.CurrentInstaScreen.currentInstaScreen.value
    Scaffold(
        topBar = {
            when (currentInstaScreen) {
                "insta_home" -> {
                    InstaHomeScreenTopBar()
                }
                "insta_profile" -> {
                    InstaProfileTopBar()
                }
                else -> {
                    InstaHomeScreenTopBar()
                }
            }
        },
        bottomBar = {
            InstaBottomNavBar(
                navController = navController
            )
        },
        backgroundColor = Color.Black
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavScreenController(navController = navController)
        }
    }
}


@Composable
fun InstaBottomNavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = Color.Black,
        elevation = 8.dp,
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route

        BottomNavItem.Items.items.forEach {
            BottomNavigationItem(
                selected = currentRoute == it.route,
                onClick = {
                    if (currentRoute != it.route) {
                        navController.graph.startDestinationRoute?.let { item ->
                            navController.popBackStack(
                                item, false
                            )
                        }
                    }

                    if (currentRoute != it.route) {
                        navController.navigate(it.route) {
                            launchSingleTop =
                                true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(it.icon),
                        contentDescription = it.label,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }
    }
}

@Composable
fun NavScreenController(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "insta_home") {
        composable("insta_home") {
            BottomNavItem.CurrentInstaScreen.currentInstaScreen.value =
                navController.currentDestination?.route!!
            InstaHomePage()
        }
        composable("insta_profile") {
            BottomNavItem.CurrentInstaScreen.currentInstaScreen.value =
                navController.currentDestination?.route!!
            InstaProfilePage()
        }
        composable("insta_explore") {
            BottomNavItem.CurrentInstaScreen.currentInstaScreen.value =
                navController.currentDestination?.route!!
            InstaHomePage()
        }
        composable("insta_reels") {
            BottomNavItem.CurrentInstaScreen.currentInstaScreen.value =
                navController.currentDestination?.route!!
            InstaHomePage()
        }
        composable("insta_activity") {
            BottomNavItem.CurrentInstaScreen.currentInstaScreen.value =
                navController.currentDestination?.route!!
            InstaHomePage()
        }
    }
}

@Preview
@Composable
fun InstaBottomBarPreview() {
    InstaBottomNavBar(rememberNavController())
}
