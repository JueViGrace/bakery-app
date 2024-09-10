package com.bakery.app.core.di

import com.bakery.app.core.data.local.DriverFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val desktopModule = module {
    singleOf(::DriverFactory)
}
