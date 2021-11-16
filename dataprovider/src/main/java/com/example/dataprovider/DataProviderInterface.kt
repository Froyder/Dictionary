package com.example.dataprovider

import com.example.model.DataModel

interface DataProviderInterface {
    suspend fun getDataFromSource(word: String): List<DataModel>
    suspend fun addWordToFavorite(vararg arguments: String)
    suspend fun getFavoritesList (): List<DataModel>
    suspend fun getHistoryListFromLocalStorage(): List<DataModel>
}