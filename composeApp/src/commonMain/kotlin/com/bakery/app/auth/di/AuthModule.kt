package com.bakery.app.auth.di

import com.bakery.app.auth.data.repository.AuthRepositoryImpl
import com.bakery.app.auth.domain.AuthRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authModule = module {
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
}
