package com.example.favorite.domain.repository

import com.example.favorite.data.local.model.DataEntity
import com.example.shared.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface DataLocalRepositories {
    fun getData(): Flow<ResultState<List<DataEntity>>>
    fun getDatabyId(id: Int): Flow<ResultState<DataEntity>>
    suspend fun insertData(dataEntity: DataEntity)
    suspend fun deleteData(dataEntity: DataEntity)
}