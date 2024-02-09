package com.zagart.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.compose.presentation.EventBus
import com.zagart.compose.presentation.HomeViewModel
import com.zagart.compose.ui.composables.ComposeApp
import dagger.hilt.android.AndroidEntryPoint


val LocalEventBus = staticCompositionLocalOf { EventBus() }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeViewModel by viewModels<HomeViewModel>()

        setContent {
            CompositionLocalProvider(LocalEventBus provides homeViewModel.eventBus) {
                ComposeApp(
                    homeState = homeViewModel.state.collectAsStateWithLifecycle()
                )
            }
        }
    }
}
