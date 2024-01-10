package com.example.bucketlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            AppBar(title = "Bucket List") {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)) {

        }
    }
}