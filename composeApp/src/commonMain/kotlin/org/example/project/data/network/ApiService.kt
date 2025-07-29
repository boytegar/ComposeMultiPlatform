package org.example.project.data.network

import com.example.shared.utils.ApiResponse
import de.jensklingenberg.ktorfit.http.GET
import kotlinx.coroutines.flow.Flow

interface ApiService {
    @GET("success.json")
    suspend fun getData(): ApiResponse<List<DataDto>>

    @GET("failed.json")
    suspend fun getDataFailed(): ApiResponse<List<DataDto>>
}