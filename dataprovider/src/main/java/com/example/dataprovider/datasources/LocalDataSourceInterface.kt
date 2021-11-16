package com.example.dataprovider.datasources

import com.example.model.DataModel


interface LocalDataSourceInterface {

    suspend fun onLoadingDataError() : List<DataModel>
    suspend fun getWordFromLocalStorage(word: String): DataModel
    suspend fun updateWordInDB(vararg arguments: String)
    suspend fun getFavoritesListFromLocalStorage(): List<DataModel>
    suspend fun getHistoryListFromDB(): List<DataModel>
    suspend fun addListToLocalStorage(list: List<DataModel>)
}