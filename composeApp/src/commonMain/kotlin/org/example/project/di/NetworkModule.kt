package org.example.project.di

import com.example.shared.utils.Constants
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.data.network.createApiService
import org.koin.dsl.module


val networkModule = module {
    single {
        get<Ktorfit>().createApiService()
    }
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(get(), contentType = ContentType.Any)
            }
        }
    }
    single {
        Ktorfit.Builder()
            .baseUrl(Constants.BASE_URL)
            .httpClient(get<HttpClient>())
            .build()
    }

    single {
        Json { ignoreUnknownKeys = true }
    }



}