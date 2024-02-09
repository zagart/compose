package com.zagart.compose.data.entities

data class ComposeItem(
    val id: String,
    val name: String = "Item name",
    val description: String = "Description with lots of details about item.",
    val meta: String = "META",
)