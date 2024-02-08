package com.zagart.compose.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun FailureScreen() {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.errorContainer)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Failure",
                color = MaterialTheme.colorScheme.onErrorContainer,
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}