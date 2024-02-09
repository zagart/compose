package com.zagart.compose.ui.composables.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zagart.compose.data.entities.ComposeItem
import com.zagart.compose.ui.composables.screens.library.TopBar

@Preview
@Composable
fun DetailsScreen(item: ComposeItem = ComposeItem(id = "0"), onBackPressed: () -> Unit = {}) {
    BackHandler(onBack = onBackPressed)
    Surface {
        Scaffold(
            topBar = {
                TopBar(title = "Details")
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