package com.example.favorite.data.impl

import com.example.favorite.data.local.model.DataEntity


interface DataLocalRepositoryImpl {
    suspend fun getDataLocal(): List<DataEntity>
    suspend fun insertData(dataEntity: DataEntity)
    suspend fun deleteData(dataEntity: DataEntity)
    suspend fun getDataById(id: Int) : DataEntity
}