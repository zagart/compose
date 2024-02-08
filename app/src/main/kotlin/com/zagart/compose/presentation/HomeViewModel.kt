package com.zagart.compose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface HomeState

class HomeViewModel : ViewModel() {

    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(Loading)
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _state.value = Success((1..10).toList().map { it.toString() })
        }
    }
}

data object Loading : HomeState
data object Failure : HomeState
data class Success(val items: List<String>) : HomeState


