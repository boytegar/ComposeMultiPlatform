package com.example.favorite.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.favorite.data.local.MyDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<MyDatabase> {
    val dbFile = context.getDatabasePath("my.db")
    return Room.databaseBuilder(
        context,
        dbFile.absolutePath
    )
}