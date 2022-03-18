package com.zoom_machine.jetpack_compose_custom_view.nav_graph

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zoom_machine.jetpack_compose_custom_view.di.DaggerScreenCartoonComponent
import com.zoom_machine.jetpack_compose_custom_view.di.DaggerScreenWidgetComponent
import com.zoom_machine.jetpack_compose_custom_view.di.daggerViewModel
import com.zoom_machine.jetpack_compose_custom_view.screens.*
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel
import com.zoom_machine.jetpack_compose_custom_view.view_models.RickMortyViewModel


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
            val viewModel: RickMortyViewModel = daggerViewModel {
                component.getViewModel()
            }

            CartoonScreen(viewModel = viewModel)
        }
        composable(route = BottomBarScreen.CatHouse.route){
            CatHouseScreen()
        }
    }
}