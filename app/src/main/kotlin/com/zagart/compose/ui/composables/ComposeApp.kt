package com.zagart.compose.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.zagart.compose.presentation.Failure
import com.zagart.compose.presentation.HomeState
import com.zagart.compose.presentation.Loading
import com.zagart.compose.presentation.Success
import com.zagart.compose.ui.composables.screens.FailureScreen
import com.zagart.compose.ui.composables.screens.HomeScreen
import com.zagart.compose.ui.composables.screens.LoadingScreen
import com.zagart.compose.ui.theme.ComposeTheme

@Composable
fun ComposeApp(homeState: State<HomeState>) {
    ComposeTheme {
        when (val currentHomeState = homeState.value) {
            is Failure -> FailureScreen()
            is Loading -> LoadingScreen()
            is Success -> HomeScreen(currentHomeState)
        }
    }
}