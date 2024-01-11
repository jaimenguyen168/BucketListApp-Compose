package com.example.bucketlistapp.data

import kotlinx.coroutines.flow.Flow

class BucketRepository(private val bucketListDAO: BucketListDAO) {

    suspend fun addAnItem(item: BucketLister) {
        bucketListDAO.addAnItem(item)
    }

    suspend fun updateAnItem(item: BucketLister) {
        bucketListDAO.updateAnItem(item)
    }

    suspend fun deleteAnItem(item: BucketLister) {
        bucketListDAO.deleteAnItem(item)
    }

    fun getAnItem(id: Long) : Flow<BucketLister> = bucketListDAO.getAnItemById(id)

    fun getAllItems() : Flow<List<BucketLister>> = bucketListDAO.getAllItems()
}