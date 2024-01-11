package com.example.bucketlistapp

import android.app.Application

// Need to be registered in Manifest
class BucketListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this) // context needed to set up database
    }
}