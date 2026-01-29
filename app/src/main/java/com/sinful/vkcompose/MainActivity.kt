package com.sinful.vkcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.sinful.vkcompose.ui.theme.FirstComposeTheme
import com.sinful.vkcompose.ui.theme.MainScreen
import com.vk.id.VKID

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VKID.init(this)
        enableEdgeToEdge()
        setContent {
            FirstComposeTheme {
                MainScreen()
            }
        }
    }
}