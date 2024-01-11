package com.example.bucketlistapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bucketlistapp.data.BucketLister
import kotlinx.coroutines.launch

@Composable
fun AddEditScreen(
    viewModel: BucketListViewModel,
    navController: NavController
) {
    val id = viewModel.bucketListIdSelected.value
    var action = ""

    if (id != 0L) {
        action = stringResource(id = R.string.update_bucket)
        val item = viewModel.getItemById(id).collectAsState(initial = BucketLister(0L, "", ""))
        viewModel.bucketListTitleState = item.value.title
        viewModel.bucketListDescState = item.value.description
    } else {
        action = stringResource(id = R.string.add_bucket)
        viewModel.bucketListTitleState = ""
        viewModel.bucketListDescState = ""
    }

    val controller = LocalSoftwareKeyboardController.current

    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold (
        topBar = { 
            CustomAppBar(
                title = action,
                onBackNavClicked = {
                    navController.navigateUp() // Help to popBackStack
                }
            )
        },
        scaffoldState = scaffoldState
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

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                onClick = {
                    if (viewModel.bucketListTitleState.isNotEmpty()
                        && viewModel.bucketListDescState.isNotEmpty()) {
                        // TODO Add
                        // TODO Update
                        when (id) {
                            0L -> {
                                viewModel.add(
                                    BucketLister(
                                        title = viewModel.bucketListTitleState.trim(),
                                        description = viewModel.bucketListDescState.trim()
                                    )
                                )
                                viewModel.selectedId(0L)
                                snackMessage.value = "New goal added in your Bucket List"
                            }
                        }
                    } else {
                        snackMessage.value = "Enter fields to create a new item in your Bucket List"
                    }
                    controller?.hide()
                    scope.launch {
                        // Cant be omitted to make the app feel faster
//                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                        navController.navigateUp()
                    }
                }
            ) {
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

