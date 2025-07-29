package org.example.project.data.repository

import com.example.shared.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.example.project.data.impl.DataRepositoryImpl
import org.example.project.data.network.ApiService
import org.example.project.data.network.DataDto
import org.koin.core.annotation.Single

@Single
class DataRepository(private val apiService: ApiService): DataRepositoryImpl {

    override suspend fun getData(): ApiResponse<List<DataDto>> {
        return apiService.getData()
    }

    override suspend fun getDataFailed(): ApiResponse<List<DataDto>> {
        return  apiService.getDataFailed()
    }
}