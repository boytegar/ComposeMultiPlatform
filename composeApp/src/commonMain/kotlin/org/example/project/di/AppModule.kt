package org.example.project.di

import org.koin.core.annotation.Module

@Module(includes = [NetworkModule::class, ViewModelModule::class, RepositoryModule::class, UseCaseModule::class])
class AppModule