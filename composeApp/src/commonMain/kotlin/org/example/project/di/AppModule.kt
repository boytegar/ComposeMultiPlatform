package org.example.project.di

import com.example.favorite.di.repositoryFavoriteModule
import com.example.favorite.di.sharedModule
import com.example.favorite.di.targetModule
import com.example.favorite.di.usecaseFavoriteModule
import com.example.favorite.di.viewmodelFavoriteModule
import org.koin.core.module.Module


//@Module(includes = [NetworkModule::class, ViewModelModule::class, RepositoryModule::class, UseCaseModule::class])
//class AppModule

class AppModule {
    val module: List<Module> = listOf(

        networkModule,
        targetModule,
        sharedModule,
        repositoryModule,
        usecaseModule,
        viewmodelModule,
    )
}