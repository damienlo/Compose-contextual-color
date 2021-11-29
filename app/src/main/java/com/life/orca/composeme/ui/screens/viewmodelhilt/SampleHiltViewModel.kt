package com.life.orca.composeme.ui.screens.viewmodelhilt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleHiltViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf<SampleHiltState>(SampleHiltState.Loading)
    val state: SampleHiltState by _state

    init {
        fetch()
    }

    fun onRetryButtonClicked() {
        fetch()
    }

    private fun fetch() {
        _state.value = SampleHiltState.Loading
        viewModelScope.launch {
            try {
                delay(2_500L)
                _state.value = SampleHiltState.Success("page loaded successfully")
            } catch (e: Exception) {
                _state.value = SampleHiltState.Error(e)
            }
        }
    }
}

sealed class SampleHiltState {
    object Loading : SampleHiltState()
    data class Success(val data: String) : SampleHiltState()
    data class Error(val cause: Exception) : SampleHiltState()
}
