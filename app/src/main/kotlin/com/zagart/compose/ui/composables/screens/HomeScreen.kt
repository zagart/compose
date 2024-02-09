package com.zagart.compose.ui.composables.screens

import androidx.compose.foundation.clickable
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
import com.zagart.compose.data.entities.ComposeItem
import com.zagart.compose.presentation.Success
import com.zagart.compose.ui.composables.screens.library.TopBar

@Composable
fun HomeScreen(state: Success, onItemPressed: (ComposeItem) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(topBar = { TopBar(title = "Home") }) {
            Box(modifier = Modifier.padding(it)) {
                Column {
                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(8.dp),
                        text = "State ID: ${state.hashCode()}",
                        style = MaterialTheme.typography.displaySmall
                    )
                    LazyColumn {
                        items(state.items) { item ->
                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(8.dp)
                                    .clickable { onItemPressed(item) },
                                text = "New item: ${item.name}",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    }
}