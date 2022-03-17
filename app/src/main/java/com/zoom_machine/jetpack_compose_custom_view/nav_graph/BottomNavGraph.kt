package com.zoom_machine.jetpack_compose_custom_view.nav_graph

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zoom_machine.jetpack_compose_custom_view.screens.*
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Widget.route
    ) {
        composable(route = BottomBarScreen.Widget.route){
            WidgetScreen()
        }
        composable(route = BottomBarScreen.Cartoon.route){
            CartoonScreen()
        }
        composable(route = BottomBarScreen.CatHouse.route){
            CatHouseScreen()
        }
    }
}