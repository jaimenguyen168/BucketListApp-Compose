package com.example.bucketlistapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { AppBar(title = "Bucket List") }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)) {

        }
    }
}