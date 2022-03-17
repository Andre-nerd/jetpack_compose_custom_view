package com.zoom_machine.jetpack_compose_custom_view.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.zoom_machine.jetpack_compose_custom_view.screens.custom_component.ArcIndicator
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(viewModel: IndicatorsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    val progressIndicator = remember { mutableStateOf(0) }
    viewModel.viewModelScope.launch {
        viewModel.progress.collect { progress ->
            Log.d("PRGS", "getProgressIndicator() Screen collect = $progress")
            progressIndicator.value = progress
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter

    ) {
        ArcIndicator(
            canvasSize = 200.dp,
            indicatorValue = progressIndicator.value
        )
        Text(
            modifier = Modifier.padding(top = 150.dp),
            text = "Home",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}


