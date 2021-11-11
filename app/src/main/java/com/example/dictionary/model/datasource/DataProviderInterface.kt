package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

interface DataProviderInterface {
    suspend fun getDataFromSource(word: String): List<DataModel>
    suspend fun addWordToFavorite(vararg arguments: String)
    suspend fun getFavoritesList (): List<DataModel>
    suspend fun getHistoryListFromLocalStorage(): List<DataModel>
}