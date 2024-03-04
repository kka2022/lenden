package com.example.lenden.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen() {
    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Text(text = "Details")
    }
}