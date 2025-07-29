package org.example.project.data.impl

import com.example.shared.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import org.example.project.data.network.DataDto

interface DataRepositoryImpl {
    suspend fun getData(): ApiResponse<List<DataDto>>
    suspend fun getDataFailed(): ApiResponse<List<DataDto>>
}