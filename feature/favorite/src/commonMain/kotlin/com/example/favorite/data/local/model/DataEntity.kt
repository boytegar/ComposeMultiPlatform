package com.example.favorite.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    val _id : Int = 0,
    val artistDisplayName: String,
    val creditLine: String,
    val department: String,
    val dimensions: String,
    val medium: String,
    val objectDate: String,
    val objectID: Int,
    val objectURL: String,
    val primaryImage: String,
    val primaryImageSmall: String,
    val repository: String,
    val title: String
)