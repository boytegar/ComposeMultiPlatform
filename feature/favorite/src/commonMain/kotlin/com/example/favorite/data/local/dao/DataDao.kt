package com.example.favorite.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.favorite.data.local.model.DataEntity

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: DataEntity)
    @Update
    suspend fun updateData(data: DataEntity)
    @Delete
    suspend fun deleteData(data: DataEntity)
    @Transaction
    @Query("SELECT * FROM data WHERE _id= :id ")
    suspend fun getDataById(id: Int) : DataEntity

    @Transaction
    @Query("SELECT * FROM data")
    suspend fun getAllData() : List<DataEntity>
}