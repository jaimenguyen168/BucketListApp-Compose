package com.example.bucketlistapp.data

data class BucketLister(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyBucket {
    val bucketList = listOf(
        BucketLister(title = "Apple Watch 8", description = "New cool features"),
        BucketLister(title = "Apple Vision Pro", description = "Looks pretty dope"),
        BucketLister(title = "Apple Imac", description = "Why not"),
        BucketLister(title = "Master of The Air", description = "Seems worthy watching"),
        BucketLister(title = "Internship", description = "For the love of God, apply now"),
    )
}
