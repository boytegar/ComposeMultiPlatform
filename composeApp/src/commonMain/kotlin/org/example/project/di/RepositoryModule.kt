package org.example.project.di

import com.example.favorite.data.repository.DataLocalRepository
import com.example.favorite.di.repositoryFavoriteModule
import org.example.project.data.repository.DataRepository
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module

//@Module
//@ComponentScan("org.example.project.data")
//class RepositoryModule

val repositoryModule = module{
    single {
        DataRepository(get())
    }
    includes(
        repositoryFavoriteModule
    )
}