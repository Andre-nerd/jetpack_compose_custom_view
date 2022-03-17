package com.zoom_machine.jetpack_compose_custom_view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.zoom_machine.jetpack_compose_custom_view.screens.custom_component.ArcIndicator
import com.zoom_machine.jetpack_compose_custom_view.screens.custom_component.LoadingAnimation
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun WidgetScreen(viewModel: IndicatorsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    val progressIndicator = remember { mutableStateOf(0) }
    val progressOutput = remember { mutableStateOf(0) }

    viewModel.viewModelScope.launch {
        viewModel.progress.collect { progress ->
            progressIndicator.value = progress
        }
    }
    viewModel.viewModelScope.launch {
        viewModel.progressOutput.collect { progress ->
            progressOutput.value = progress
        }
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, bottom = 60.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,


    ) {
        ArcIndicator(
            canvasSize = 200.dp,
            indicatorValue = progressIndicator.value
        )
        Box(
            modifier = Modifier.padding(top = 80.dp, bottom = 80.dp)
        ) {
            val circleColor = listOf(
                MaterialTheme.colors.primary,
                Color.Magenta,
                Color.Cyan
            )
            LoadingAnimation(circleColor = circleColor)
        }

        ArcIndicator(
            canvasSize = 200.dp,
            indicatorValue = progressOutput.value,
            arcMaxAngle = 3.6f,
            startAngle = 180f,
            foregroundIndicatorColor = Color.Magenta,
            smallText = "Sent"
        )
    }
}


