package com.example.favorite.data.repository

import com.example.favorite.data.impl.DataLocalRepositoryImpl
import com.example.favorite.data.local.MyDatabase
import com.example.favorite.data.local.model.DataEntity
import org.koin.core.annotation.Single

@Single
class DataLocalRepository(private val myDatabase: MyDatabase): DataLocalRepositoryImpl {
    override suspend fun getDataLocal(): List<DataEntity> {
        return myDatabase.dataDao().getAllData()
    }

    override suspend fun insertData(dataEntity: DataEntity) {
        myDatabase.dataDao().insertData(dataEntity)
    }

    override suspend fun deleteData(dataEntity: DataEntity) {
        myDatabase.dataDao().deleteData(dataEntity)
    }

    override suspend fun getDataById(id: Int): DataEntity {
       return myDatabase.dataDao().getDataById(id)
    }
}