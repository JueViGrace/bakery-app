package com.bakery.app.core.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

val coroutinesModule = module {
    single<CoroutineContext> {
        Dispatchers.Default
    }

    singleOf(::CoroutineScope) bind CoroutineScope::class
}
