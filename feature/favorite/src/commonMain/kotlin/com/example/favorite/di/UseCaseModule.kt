package com.example.favorite.di

import com.example.favorite.domain.usecase.DataLocalUseCase
import org.koin.dsl.module

val usecaseFavoriteModule = module {
    single {
        DataLocalUseCase(get())
    }
}