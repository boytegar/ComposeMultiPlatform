package org.example.project.domain.usecase

import com.example.shared.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.data.network.DataDto
import org.example.project.data.repository.DataRepository
import org.example.project.domain.repositories.DataRepositories
import org.koin.core.annotation.Single

@Single
class DataUseCase(private val dataRepository: DataRepository): DataRepositories {
    override fun getData(): Flow<ResultState<List<DataDto>>> = flow {
        emit(ResultState.Loading)
        try {
            val response = dataRepository.getData()
            if (response.code == 200) {
                response.data?.let {
                    emit(ResultState.Success(it))
                } ?: emit(ResultState.Error(
                    message = "Data is null in a successful response",
                    code = response.code
                ))
            } else {
                emit(ResultState.Error(
                    message = response.message ?: "Unknown error",
                    code = response.code
                ))
            }
        } catch (e: Exception) {
            emit(ResultState.Error(
                message = e.toString(),
                exception = e
            ))
        }
    }

    override fun getDataFailed(): Flow<ResultState<List<DataDto>>> = flow {
        emit(ResultState.Loading)
        try {
            val response = dataRepository.getDataFailed()
            if (response.code == 200) {
                response.data?.let {
                    emit(ResultState.Success(it))
                } ?: emit(ResultState.Error(
                    message = "Data is null in a successful response",
                    code = response.code
                ))
            } else {
                emit(ResultState.Error(
                    message = response.message ?: "Unknown error",
                    code = response.code
                ))
            }
        } catch (e: Exception) {
            emit(ResultState.Error(
                message = e.toString(),
                exception = e
            ))
        }
    }

}