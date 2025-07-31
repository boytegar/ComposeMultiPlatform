package org.example.project.di

import com.example.favorite.di.usecaseFavoriteModule
import com.example.favorite.domain.usecase.DataLocalUseCase
import org.example.project.domain.usecase.DataUseCase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module
import kotlin.math.sin

//@Module
//@ComponentScan("org.example.project.domain.usecase")
//class UseCaseModule
val usecaseModule = module {
    single {
        DataUseCase(get())
    }
    includes(
        usecaseFavoriteModule
    )
}