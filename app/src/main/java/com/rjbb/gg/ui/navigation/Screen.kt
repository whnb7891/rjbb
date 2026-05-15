package com.rjbb.gg.ui.navigation

sealed class Screen(val route: String) {
    object Search : Screen("search")
    object Results : Screen("results")
    object Settings : Screen("settings")
}