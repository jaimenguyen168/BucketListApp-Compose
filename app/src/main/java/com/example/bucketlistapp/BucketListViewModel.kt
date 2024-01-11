package com.example.bucketlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BucketListViewModel : ViewModel() {
    var bucketListTitleState by mutableStateOf("")
    var bucketListDescState by mutableStateOf("")

    fun onTitleChanged(newTitle: String) {
        bucketListTitleState = newTitle
    }

    fun onDescriptionChanged(newDescription: String) {
        bucketListDescState = newDescription
    }
}