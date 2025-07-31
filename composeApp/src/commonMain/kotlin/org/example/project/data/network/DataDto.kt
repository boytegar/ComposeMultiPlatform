package org.example.project.data.network

import com.example.favorite.data.local.model.DataEntity
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
fun DataDto.toDataEntity(): DataEntity {
    return DataEntity(
        artistDisplayName = this.artistDisplayName,
        creditLine = this.creditLine,
        department = this.department,
        dimensions = this.dimensions,
        medium = this.medium,
        objectDate = this.objectDate,
        objectID = this.objectID,
        objectURL = this.objectURL,
        primaryImage = this.primaryImage,
        primaryImageSmall = this.primaryImageSmall,
        repository = this.repository,
        title = this.title
    )
}