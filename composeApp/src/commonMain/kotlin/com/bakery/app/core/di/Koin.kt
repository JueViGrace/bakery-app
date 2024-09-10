package com.bakery.app.core.di

import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.koinApplication

fun koinConfiguration() = koinApplication {
    modules(appModule())
}

fun initKoin(
    additionalModules: List<Module> = emptyList(),
    appDeclaration: KoinAppDeclaration = {}
) = koinApplication {
    appDeclaration()
    modules(appModule() + additionalModules)
}
