package com.example.dictionary.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "words")
data class DataModel(
    @PrimaryKey
    @ColumnInfo(name = "text")
    @field:SerializedName("text") val text: String,
    @ColumnInfo(name = "meanings")
    @field:SerializedName("meanings") val meanings: List<Meanings>?,
    @ColumnInfo(name = "isFavorite")
    @field:SerializedName("isFavorite") val isFavorite: String? = "false"
)

class Meanings(
    @ColumnInfo(name = "translation")
    @field:SerializedName("translation") val translation: Translation?,
    @ColumnInfo(name = "imageUrl")
    @field:SerializedName("imageUrl") val imageUrl: String?
)

class Translation(
    @ColumnInfo(name = "text")
    @field:SerializedName("text") val translation: String?
    )