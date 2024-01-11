package com.example.bucketlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddEditScreen(
    id: Long,
    viewModel: BucketListViewModel,
    navController: NavController
) {

    val action = if (id != 0L) stringResource(id = R.string.update_bucket) else stringResource(id = R.string.add_bucket)

    Scaffold (
        topBar = { 
            CustomAppBar(
                title = action,
                onBackNavClicked = {
                    navController.navigateUp() // Help to popBackStack
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(
                modifier = Modifier.height(10.dp)
            )

            AddEditView(
                label = "Title",
                value = viewModel.bucketListTitleState,
                onValueChanged = {
                    viewModel.onTitleChanged(it)
                }
            )

            AddEditView(
                label = "Description",
                value = viewModel.bucketListDescState,
                onValueChanged = {
                    viewModel.onDescriptionChanged(it)
                }
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Button(onClick = {
                if (viewModel.bucketListTitleState.isNotEmpty()
                    && viewModel.bucketListDescState.isNotEmpty()) {
                    // TODO Update
                } else {
                    // TODO Add
                }
                navController.navigateUp()
            }) {
                Text(
                    text = action,
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}

