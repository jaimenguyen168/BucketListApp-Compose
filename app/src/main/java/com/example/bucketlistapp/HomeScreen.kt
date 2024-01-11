package com.example.bucketlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.bucketlistapp.data.DummyBucket

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
                Toast.makeText(context, "Floating Button Clicked", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.AddEditItemScreen.route)
            }
        }
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            items(DummyBucket.bucketList) {
                BucketListItem(item = it) {
                    viewModel.onTitleChanged(it.title)
                    viewModel.onDescriptionChanged(it.description)
                    navController.navigate(Screen.AddEditItemScreen.route)
                }
            }
        }
    }
}