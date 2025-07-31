package com.example.favorite.di

import com.example.favorite.data.repository.DataLocalRepository
import org.koin.dsl.module

val repositoryFavoriteModule = module{
    single {
        DataLocalRepository(get())
    }
}