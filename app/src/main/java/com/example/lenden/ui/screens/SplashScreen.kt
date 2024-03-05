package com.example.lenden.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lenden.R
import com.example.lenden.ui.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var sizeState by remember {
        mutableStateOf(100.dp)
    }
    val size by animateDpAsState(
        targetValue = sizeState,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        ),
        label = "size"
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.money_image),
            contentDescription = "splash screen image",
            modifier = Modifier.size(size),
            contentScale = ContentScale.FillBounds,
        )
    }
    LaunchedEffect(key1 = true) {
        sizeState = 140.dp
        delay(1000)
        sizeState = 120.dp
        delay(1000)

        navController.navigate(AppScreens.Home.name) {
            popUpTo(AppScreens.Splash.name) {
                inclusive = true
            }
        }
    }
}