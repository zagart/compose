package com.zagart.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.compose.presentation.HomeViewModel
import com.zagart.compose.ui.composables.ComposeApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeViewModel by viewModels<HomeViewModel>()

        setContent {
            ComposeApp(
                homeState = homeViewModel.state.collectAsStateWithLifecycle(),
                eventBus = homeViewModel.eventBus
            )
        }
    }
}
