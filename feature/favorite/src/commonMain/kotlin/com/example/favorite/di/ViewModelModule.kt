package com.example.favorite.di

import com.example.favorite.presentation.FavoriteViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewmodelFavoriteModule = module {
    viewModelOf(::FavoriteViewModel)

}