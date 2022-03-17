package com.zoom_machine.jetpack_compose_custom_view.nav_graph

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zoom_machine.jetpack_compose_custom_view.screens.BottomBarScreen
import com.zoom_machine.jetpack_compose_custom_view.screens.HomeScreen
import com.zoom_machine.jetpack_compose_custom_view.screens.ProfileScreen
import com.zoom_machine.jetpack_compose_custom_view.screens.SettingScreen
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Setting.route){
            SettingScreen()
        }
    }
}