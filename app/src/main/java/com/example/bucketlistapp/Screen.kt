package com.example.bucketlistapp

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("homeScreen")
    data object AddItemScreen: Screen("addItemScreen")
}