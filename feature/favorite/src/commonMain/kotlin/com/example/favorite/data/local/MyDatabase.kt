

package com.example.favorite.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.favorite.data.local.dao.DataDao
import com.example.favorite.data.local.model.DataEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [DataEntity::class],
    version = 1,
    exportSchema = true
)
@ConstructedBy(MyDatabaseConstructor::class)
abstract class MyDatabase: RoomDatabase() {
    abstract fun dataDao() : DataDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object MyDatabaseConstructor : RoomDatabaseConstructor<MyDatabase>{
    override fun initialize(): MyDatabase
}

fun getRoomDatabase(builder: RoomDatabase.Builder<MyDatabase>): MyDatabase{
    return builder.fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}