package com.example.bucketlistapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomFloatingActionButton(
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = Modifier.padding(20.dp),
        contentColor = Color.White,
        backgroundColor = Color.Black
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Button"
        )
    }
}