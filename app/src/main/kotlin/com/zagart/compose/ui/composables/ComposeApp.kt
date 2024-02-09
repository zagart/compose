package com.zagart.compose.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.zagart.compose.data.entities.ComposeItem
import com.zagart.compose.presentation.ComposeEventBus
import com.zagart.compose.presentation.Event
import com.zagart.compose.presentation.Failure
import com.zagart.compose.presentation.HomeState
import com.zagart.compose.presentation.Loading
import com.zagart.compose.presentation.OnBackPressedDetailsScreen
import com.zagart.compose.presentation.Success
import com.zagart.compose.ui.composables.screens.DetailsScreen
import com.zagart.compose.ui.composables.screens.FailureScreen
import com.zagart.compose.ui.composables.screens.HomeScreen
import com.zagart.compose.ui.composables.screens.LoadingScreen
import com.zagart.compose.ui.theme.ComposeTheme

@Composable
fun ComposeApp(homeState: State<HomeState>, eventBus: ComposeEventBus) {
    ComposeTheme {
        var itemPressed by rememberSaveable { mutableStateOf<ComposeItem?>(null) }

        when (val currentHomeState = homeState.value) {
            is Failure -> FailureScreen()
            is Loading -> LoadingScreen()
            is Success -> {
                if (itemPressed is ComposeItem) {
                    DetailsScreen(itemPressed!!) {
                        itemPressed = null
                        eventBus.dispatchEvent(OnBackPressedDetailsScreen)
                    }
                } else {
                    HomeScreen(currentHomeState) {
                        itemPressed = it
                    }
                }
            }
        }
    }
}