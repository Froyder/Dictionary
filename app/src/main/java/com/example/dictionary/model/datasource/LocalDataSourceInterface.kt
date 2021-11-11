package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

interface LocalDataSourceInterface {

    suspend fun onLoadingDataError() : List<DataModel>
    suspend fun getWordFromLocalStorage(word: String): DataModel
    suspend fun updateWordInDB(vararg arguments: String)
    suspend fun getFavoritesListFromLocalStorage(): List<DataModel>
    suspend fun getHistoryListFromDB(): List<DataModel>
    suspend fun addListToLocalStorage(list: List<DataModel>)
}