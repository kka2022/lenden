package com.example.lenden.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FloatingAddButton(onClick: () -> Unit = {}) {
    IconButton(onClick = onClick) {
        Surface(
            modifier = Modifier
                .size(60.dp)
                .clip(
                    RoundedCornerShape(4.dp)
                )
                .background(MaterialTheme.colorScheme.tertiary),
            shadowElevation = 4.dp
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Person",
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }
}