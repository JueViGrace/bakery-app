package com.bakery.app.home.presentation.state

import com.bakery.app.core.presentation.navigation.NavMenuTabs

data class HomeState(
    val showAccountDialog: Boolean = false,
    val tabs: List<NavMenuTabs> = listOf(NavMenuTabs.Dashboard)
)
