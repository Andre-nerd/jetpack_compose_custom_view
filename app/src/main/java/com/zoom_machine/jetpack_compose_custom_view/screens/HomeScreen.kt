package com.zoom_machine.jetpack_compose_custom_view.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleCoroutineScope
import com.zoom_machine.jetpack_compose_custom_view.utils.launchWhenStarted
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel
import kotlinx.coroutines.flow.onEach

@Composable
fun HomeScreen(viewModel: IndicatorsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    val progressIndicator = remember { mutableStateOf(0) }
    viewModel.getProgressIndicator(true)
    viewModel.progress.onEach { progress ->
        progressIndicator.value = progress
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = "Home",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

