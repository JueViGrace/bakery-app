package com.bakery.app.core.di

import org.koin.dsl.koinApplication

fun koinConfiguration() = koinApplication {
    modules(appModule())
}
