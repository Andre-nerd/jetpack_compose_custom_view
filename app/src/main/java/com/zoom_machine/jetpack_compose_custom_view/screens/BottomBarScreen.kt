package com.zoom_machine.jetpack_compose_custom_view.screens


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Widget : BottomBarScreen(
        route = "Widget",
        title = "Widget",
        icon = Icons.Default.AddCircle
    )

    object Cartoon : BottomBarScreen(
        route = "Cartoon",
        title = "Cartoon",
        icon = Icons.Default.Star
    )

    object CatHouse : BottomBarScreen(
        route = "Cat House",
        title = "Cat House",
        icon = Icons.Default.Home
    )
}
