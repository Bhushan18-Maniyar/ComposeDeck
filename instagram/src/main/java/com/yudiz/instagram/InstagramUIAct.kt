package com.yudiz.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yudiz.instagram.components.InstaNavigation
import com.yudiz.instagram.ui.theme.InstagramAppUI

class InstagramUIAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramAppUI {
                InstaNavigation()
            }
        }
    }
}
