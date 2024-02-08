package com.zagart.compose.ui.composables.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zagart.compose.presentation.Success

@Composable
fun HomeScreen(currentHomeState: Success) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold {
            Box(modifier = Modifier.padding(it)) {
                Column {
                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(8.dp),
                        text = "Hello, world!",
                        style = MaterialTheme.typography.displaySmall
                    )
                    LazyColumn {
                        items(currentHomeState.items) { item ->
                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(8.dp),
                                text = "New item: $item",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    }
}