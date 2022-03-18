package com.zoom_machine.jetpack_compose_custom_view.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zoom_machine.jetpack_compose_custom_view.presentation.di.DaggerScreenCartoonComponent
import com.zoom_machine.jetpack_compose_custom_view.presentation.di.DaggerScreenWidgetComponent
import com.zoom_machine.jetpack_compose_custom_view.presentation.di.daggerViewModel
import com.zoom_machine.jetpack_compose_custom_view.presentation.screens.BottomBarScreen
import com.zoom_machine.jetpack_compose_custom_view.presentation.screens.CartoonScreen
import com.zoom_machine.jetpack_compose_custom_view.presentation.screens.CatHouseScreen
import com.zoom_machine.jetpack_compose_custom_view.presentation.screens.WidgetScreen
import com.zoom_machine.jetpack_compose_custom_view.presentation.view_models.IndicatorsViewModel
import com.zoom_machine.jetpack_compose_custom_view.presentation.view_models.CartoonViewModel


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Widget.route
    ) {
        composable(route = BottomBarScreen.Widget.route){
            val component = DaggerScreenWidgetComponent.builder().build()
            val viewModel: IndicatorsViewModel = daggerViewModel {
                component.getViewModel()
            }
            WidgetScreen(viewModel = viewModel)
        }
        composable(route = BottomBarScreen.Cartoon.route){
            val component = DaggerScreenCartoonComponent.builder().build()
            val viewModel: CartoonViewModel = daggerViewModel {
                component.getViewModel()
            }

            CartoonScreen(viewModel = viewModel)
        }
        composable(route = BottomBarScreen.CatHouse.route){
            CatHouseScreen()
        }
    }
}