package com.example.bucketlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BucketListDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAnItem(bucketEntity: BucketLister)

    @Update
    abstract suspend fun updateAnItem(bucketEntity: BucketLister)

    @Delete
    abstract suspend fun deleteAnItem(bucketEntity: BucketLister)


    // No need to suspend because of Flow is part of Coroutine
    @Query("Select * from `bucket-list-table` where id=:id")
    abstract fun getAnItemById(id: Long) : Flow<BucketLister>

    @Query("Select * from `bucket-list-table`")
    abstract fun getAllItems() : Flow<List<BucketLister>> // Flow - reactive stream like LiveData
}