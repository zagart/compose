package com.zagart.compose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagart.compose.data.entities.ComposeItem
import com.zagart.compose.data.repositories.ComposeItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ComposeItemRepository
) : ViewModel() {

    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(Loading)
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        update()
    }

    fun requestUpdate() {
        update()
    }

    private fun update() {
        viewModelScope.launch {
            repository.getItems().collectLatest {
                _state.value = Success(it.getOrThrow())
            }
        }
    }
}

sealed interface HomeState
data object Loading : HomeState
data object Failure : HomeState
data class Success(val items: List<ComposeItem>) : HomeState


