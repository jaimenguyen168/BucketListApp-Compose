package com.example.bucketlistapp

import android.app.Application
import com.example.bucketlistapp.data.Graph

// Need to be registered in Manifest
class BucketListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this) // context needed to set up database
    }
}