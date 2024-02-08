package com.zagart.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.compose.presentation.HomeViewModel
import com.zagart.compose.ui.composables.ComposeApp

class MainActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeApp(homeViewModel.state.collectAsStateWithLifecycle())
        }
    }
}