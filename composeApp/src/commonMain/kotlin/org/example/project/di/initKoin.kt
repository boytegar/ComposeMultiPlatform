package org.example.project.di


import org.koin.core.annotation.Module
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes


fun initKoin(config : KoinAppDeclaration ?= null) {
    startKoin {
        printLogger()
        includes(config)
        modules(
            AppModule().module,
        )
    }
}

