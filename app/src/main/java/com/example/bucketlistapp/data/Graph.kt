package com.example.bucketlistapp.data

import android.content.Context
import androidx.room.Room

// Need to be initialized globally
object Graph {
    private lateinit var database: BucketListDatabase

    val bucketListRepo by lazy {
        BucketListRepository(bucketListDAO = database.bucketListDAO())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            BucketListDatabase::class.java,
            "bucketList.db")
            .build()
    }
}