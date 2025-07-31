package org.example.project.di

import com.example.favorite.di.viewmodelFavoriteModule
import com.example.favorite.presentation.FavoriteViewModel
import org.example.project.presentation.DataViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

//@Module
//@ComponentScan("org.example.project.presentation")
//class ViewModelModule

val viewmodelModule = module {
//    single {
//        DataViewModel(get(), get())
//    }
    viewModelOf(::DataViewModel)
    includes(
        viewmodelFavoriteModule
    )
}