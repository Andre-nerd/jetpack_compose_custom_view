package com.zoom_machine.jetpack_compose_custom_view.screens

import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zoom_machine.jetpack_compose_custom_view.nav_graph.BottomNavGraph
import com.zoom_machine.jetpack_compose_custom_view.R
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navHostController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Setting
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        //There color and other params
    ) {
        screens.forEach {
            AddNewItem(
                screen = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddNewItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {

    if (currentDestination != null) {
        BottomNavigationItem(
            label = {
                Text(text = screen.title)
            },
            icon = {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = stringResource(id = R.string.navigation_icon)
                )
            },
            selected = currentDestination.hierarchy.any {
                it.route == screen.route
            },
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
            onClick = {
                navHostController.navigate(screen.route){
                    popUpTo(navHostController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
        )
    }
}