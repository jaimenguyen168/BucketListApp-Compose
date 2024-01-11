package com.example.bucketlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: BucketListViewModel
) {
    val context = LocalContext.current
    val allItems = viewModel.getAllItems

    Scaffold(
        topBar = {
            CustomAppBar(title = stringResource(id = R.string.bucket_list)) {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        },

        floatingActionButton = {
            CustomFloatingActionButton {
                navController.navigate(Screen.AddEditItemScreen.route)
            }
        }
    ) {
        val bucketList = viewModel.getAllItems.collectAsState(initial = listOf())
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            items(bucketList.value) {item ->
                BucketListItemView(item = item) {
                    viewModel.selectedId(item.id)
                    navController.navigate(Screen.AddEditItemScreen.route)
                }
            }
        }
    }
}