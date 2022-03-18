package com.zoom_machine.jetpack_compose_custom_view.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoom_machine.jetpack_compose_custom_view.data.IndicatorsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class IndicatorsViewModel @Inject constructor(private val repository: IndicatorsRepository) : ViewModel() {


    private val _progress = MutableStateFlow(0)
    val progress: StateFlow<Int> = _progress.asStateFlow()

    private val _progressOutput = MutableStateFlow(0)
    val progressOutput: StateFlow<Int> = _progressOutput.asStateFlow()

    init {
        getProgressIndicator(true)
        getProgressOutput(true)
    }


    private fun getProgressIndicator(condition: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.progressIndicator(condition).collect {
                _progress.value = it
            }
        }
    }


    private fun getProgressOutput(condition: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.progressOutput(condition).collect {
                _progressOutput.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getProgressIndicator(false)
        getProgressOutput(false)
    }
}