package com.zoom_machine.jetpack_compose_custom_view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.zoom_machine.jetpack_compose_custom_view.screens.MainScreen
import com.zoom_machine.jetpack_compose_custom_view.ui.theme.Jetpack_compose_custom_viewTheme
import com.zoom_machine.jetpack_compose_custom_view.utils.launchWhenStarted
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_custom_viewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }

}

