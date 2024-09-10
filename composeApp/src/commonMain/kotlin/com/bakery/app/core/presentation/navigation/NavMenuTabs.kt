package com.bakery.app.core.presentation.navigation

import bakery_app.composeapp.generated.resources.Res
import bakery_app.composeapp.generated.resources.home
import bakery_app.composeapp.generated.resources.ic_account_circle_24px
import bakery_app.composeapp.generated.resources.ic_home_app_logo_24px
import bakery_app.composeapp.generated.resources.ic_inventory_2_24px
import bakery_app.composeapp.generated.resources.ic_receipt_24px
import bakery_app.composeapp.generated.resources.orders
import bakery_app.composeapp.generated.resources.products
import bakery_app.composeapp.generated.resources.profile
import cafe.adriel.voyager.navigator.tab.Tab
import com.bakery.app.dashboard.navigation.DashboardTab
import com.bakery.app.orders.navigation.OrdersTab
import com.bakery.app.products.navigation.ProductsTab
import com.bakery.app.profile.navigation.ProfileTab
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class NavMenuTabs(val tab: Tab, val index: UShort, val title: StringResource, val icon: DrawableResource) {
    data object Dashboard : NavMenuTabs(
        tab = DashboardTab,
        index = 0u,
        title = Res.string.home,
        icon = Res.drawable.ic_home_app_logo_24px
    )

    data object Products : NavMenuTabs(
        tab = ProductsTab,
        index = 1u,
        title = Res.string.products,
        icon = Res.drawable.ic_inventory_2_24px
    )

    data object Orders : NavMenuTabs(
        tab = OrdersTab,
        index = 2u,
        title = Res.string.orders,
        icon = Res.drawable.ic_receipt_24px
    )

    data object Profile : NavMenuTabs(
        tab = ProfileTab,
        index = 3u,
        title = Res.string.profile,
        icon = Res.drawable.ic_account_circle_24px
    )
}
