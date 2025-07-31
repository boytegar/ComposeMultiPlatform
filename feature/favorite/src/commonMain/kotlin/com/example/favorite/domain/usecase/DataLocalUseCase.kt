package com.example.favorite.domain.usecase

import com.example.favorite.data.local.model.DataEntity
import com.example.favorite.data.repository.DataLocalRepository
import com.example.favorite.domain.repository.DataLocalRepositories
import com.example.shared.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Single

@Single
class DataLocalUseCase(private val dataLocalRepository: DataLocalRepository): DataLocalRepositories {
    override fun getData(): Flow<ResultState<List<DataEntity>>> = flow {
        emit(ResultState.Loading)
        try {
            val it = dataLocalRepository.getDataLocal()
            emit(ResultState.Success(it))
        } catch (e: Exception) {
            emit(ResultState.Error(
                message = e.toString(),
                exception = e
            ))
        }
    }

    override fun getDatabyId(id: Int): Flow<ResultState<DataEntity>> = flow {
        emit(ResultState.Loading)
        try {
            val it = dataLocalRepository.getDataById(id)
            emit(ResultState.Success(it))
        } catch (e: Exception) {
            emit(ResultState.Error(
                message = e.toString(),
                exception = e
            ))
        }
    }

    override suspend fun insertData(dataEntity: DataEntity) {
        dataLocalRepository.insertData(dataEntity)
    }

    override suspend fun deleteData(dataEntity: DataEntity) {
        dataLocalRepository.deleteData(dataEntity)
    }
}