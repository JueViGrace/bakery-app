package com.bakery.app.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.bakery.app.home.presentation.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun openDialog() {
        _state.update { state ->
            state.copy(
                showAccountDialog = true
            )
        }
    }

    fun dismissDialog() {
        _state.update { state ->
            state.copy(
                showAccountDialog = false
            )
        }
    }

    /* TODO: DYNAMIC TABS */
}
