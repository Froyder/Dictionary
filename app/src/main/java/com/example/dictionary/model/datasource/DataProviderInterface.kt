package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

interface DataProviderInterface {
    suspend fun getDataFromSource(word: String): List<DataModel>
}