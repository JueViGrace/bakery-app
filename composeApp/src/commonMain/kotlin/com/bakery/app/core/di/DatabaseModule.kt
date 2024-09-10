package com.bakery.app.core.di

import com.bakery.app.core.data.local.DbHelper
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {
    singleOf(::DbHelper)
}
