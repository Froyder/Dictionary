package com.example.dictionary.model.data

import com.google.gson.annotations.SerializedName

class DataModel(
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>?
)

class Meanings(
    @field:SerializedName("translation") val translation: Translation?,
    @field:SerializedName("imageUrl") val imageUrl: String?
)

class Translation(@field:SerializedName("text") val translation: String?)