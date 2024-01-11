package com.example.bucketlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bucket-list-table")
data class BucketLister(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "bucket-list-title")
    val title: String = "",

    @ColumnInfo(name = "bucket-list-desc")
    val description: String = ""
)

object DummyBucket {
    val bucketList = listOf(
        BucketLister(id = 1L, title = "Apple Watch 8", description = "New cool features"),
        BucketLister(id = 2L, title = "Apple Vision Pro", description = "Looks pretty dope"),
        BucketLister(id = 3L, title = "Apple Imac", description = "Why not"),
        BucketLister(id = 4L, title = "Master of The Air", description = "Seems worthy watching"),
        BucketLister(id = 5L, title = "Internship", description = "For the love of God, apply now"),
    )
}
