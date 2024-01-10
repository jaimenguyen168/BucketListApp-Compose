package com.example.bucketlistapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    title: String,
    onBackNavClicked: () -> Unit = {} // Do nothing by default
) {
    TopAppBar(
        title = { Text(
                text = title,
                color = colorResource(id = R.color.white), // From xml
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
//        navigationIcon = Icons.Default.Arrow
    )
}