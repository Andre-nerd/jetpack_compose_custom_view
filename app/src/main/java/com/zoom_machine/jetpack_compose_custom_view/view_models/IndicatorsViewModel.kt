package com.zoom_machine.jetpack_compose_custom_view.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoom_machine.jetpack_compose_custom_view.data.IndicatorsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class IndicatorsViewModel:ViewModel() {
    private val repository = IndicatorsRepositoryImpl()

    private val _progress = MutableStateFlow(0)
    val progress :StateFlow<Int> = _progress.asStateFlow()

    init {
        getProgressIndicator(true)
    }


    private fun getProgressIndicator(condition:Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repository.progressIndicator(condition).collect {
                Log.d("PRGS","getProgressIndicator() in VM collect = $it")
                _progress.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getProgressIndicator(false)
    }
}