package com.example.lenden

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.lenden.ui.navigation.LenDenNavGraph
import com.example.lenden.ui.theme.LenDenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LenDenTheme {
                LenDenApp()
            }
        }
    }
}