package com.example.bucketlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bucketlistapp.data.BucketListRepository
import com.example.bucketlistapp.data.BucketLister
import com.example.bucketlistapp.data.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BucketListViewModel(
    private val bucketListRepo: BucketListRepository = Graph.bucketListRepo // by default
) : ViewModel() {

    var bucketListTitleState by mutableStateOf("")
    var bucketListDescState by mutableStateOf("")

    fun onTitleChanged(newTitle: String) {
        bucketListTitleState = newTitle
    }

    fun onDescriptionChanged(newDescription: String) {
        bucketListDescState = newDescription
    }

    lateinit var getAllItems : Flow<List<BucketLister>>
    init {
        viewModelScope.launch {
            getAllItems = bucketListRepo.getAllItems()
        }
    }

    fun getItemById(id: Long) : Flow<BucketLister> = bucketListRepo.getAnItem(id)

    fun add(item: BucketLister) {
        viewModelScope.launch(Dispatchers.IO) {
            bucketListRepo.addAnItem(item)
        }
    }

    fun update(item: BucketLister) {
        viewModelScope.launch(Dispatchers.IO) {
            bucketListRepo.updateAnItem(item)
        }
    }

    fun delete(item: BucketLister) {
        viewModelScope.launch(Dispatchers.IO) {
            bucketListRepo.deleteAnItem(item)
        }
    }
}