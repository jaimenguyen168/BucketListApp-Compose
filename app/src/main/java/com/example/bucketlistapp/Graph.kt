package com.example.bucketlistapp

import android.content.Context
import androidx.room.Room
import com.example.bucketlistapp.data.BucketListDatabase
import com.example.bucketlistapp.data.BucketRepository

// Need to be initialized globally
object Graph {
    private lateinit var database: BucketListDatabase

    val bucketRepo by lazy {
        BucketRepository(bucketListDAO = database.bucketListDAO())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            BucketListDatabase::class.java,
            "bucketList.db")
            .build()
    }
}