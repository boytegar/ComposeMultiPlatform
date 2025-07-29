package org.example.project.domain.repositories

import com.example.shared.utils.ResultState
import kotlinx.coroutines.flow.Flow
import org.example.project.data.network.DataDto


interface DataRepositories {
    fun getData(): Flow<ResultState<List<DataDto>>>
    fun getDataFailed(): Flow<ResultState<List<DataDto>>>
}