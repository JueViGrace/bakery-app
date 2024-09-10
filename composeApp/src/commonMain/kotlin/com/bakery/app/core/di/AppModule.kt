package com.bakery.app.core.di

import com.bakery.app.auth.di.authModule
import com.bakery.app.home.di.homeModule
import org.koin.core.module.Module

fun appModule(): List<Module> = listOf(coroutinesModule, databaseModule, homeModule, authModule)
