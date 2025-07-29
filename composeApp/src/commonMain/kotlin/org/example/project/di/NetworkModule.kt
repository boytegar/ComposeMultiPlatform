package org.example.project.di

import com.example.shared.utils.Constants
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.data.network.ApiService
import org.example.project.data.network.createApiService
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class NetworkModule {

    @Single
    fun provideKtorfit(client: HttpClient): Ktorfit {
        return Ktorfit.Builder()
            .baseUrl(Constants.BASE_URL)
            .httpClient(client)
            .build()
    }

    @Single
    fun json() = Json { ignoreUnknownKeys = true }

    @Single
    fun provideApiService(ktorfit: Ktorfit): ApiService {
        return ktorfit.createApiService()
    }

    @Single
    fun provideHttpClient(json: Json): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
        }
    }
}