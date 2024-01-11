package com.example.bucketlistapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddEditView(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        label = { Text(text = label, color = Color.Black) },
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            // Predefined colors
            textColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            // Overridable colors
            cursorColor = colorResource(id = R.color.purple_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            unfocusedLabelColor = colorResource(id = R.color.purple_200)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Column(Modifier.fillMaxSize()) {
        AddEditView(label = "name", value = "Get a Job") {}
    }
}