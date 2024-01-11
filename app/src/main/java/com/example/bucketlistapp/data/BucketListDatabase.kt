package com.example.bucketlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BucketLister::class],
    version = 1,
    exportSchema = false
)
abstract class BucketListDatabase : RoomDatabase() {
    abstract fun bucketListDAO() : BucketListDAO
}