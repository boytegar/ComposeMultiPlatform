package org.example.project.data.network

import kotlinx.serialization.Serializable

@Serializable
data class DataDto(
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