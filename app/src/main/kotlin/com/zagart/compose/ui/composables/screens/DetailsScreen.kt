package com.zagart.compose.ui.composables.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zagart.compose.data.entities.ComposeItem

@Preview
@Composable
fun DetailsScreen(item: ComposeItem = ComposeItem(id = "0"), onBackPressed: () -> Unit = {}) {
    BackHandler(onBack = onBackPressed)
    Surface {
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .sizeIn(minHeight = 64.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Details",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        ) { scaffoldPadding ->
            Box(modifier = Modifier.padding(scaffoldPadding)) {
                ListItem(
                    headlineContent = {
                        Text(
                            modifier = Modifier,
                            text = item.name
                        )
                    },
                    trailingContent = {
                        Text(
                            modifier = Modifier,
                            text = item.meta
                        )
                    },
                    supportingContent = {
                        Text(
                            modifier = Modifier,
                            text = item.description
                        )
                    })
            }
        }
    }
}