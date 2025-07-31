package com.example.favorite.di

import com.example.favorite.data.local.getRoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module


expect val targetModule: Module

val sharedModule = module {
    single { getRoomDatabase(get()) }
}