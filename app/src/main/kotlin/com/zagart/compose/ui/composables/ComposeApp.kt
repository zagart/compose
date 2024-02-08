package com.zagart.compose.ui.composables

import androidx.compose.runtime.Composable
import com.zagart.compose.ui.composables.screens.HomeScreen
import com.zagart.compose.ui.theme.ComposeTheme

@Composable
fun ComposeApp() {
    ComposeTheme {
        HomeScreen()
    }
}