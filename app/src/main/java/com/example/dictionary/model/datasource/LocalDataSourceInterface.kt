package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

interface LocalDataSourceInterface {

    suspend fun onLoadingDataError() : List<DataModel>
    suspend fun addWordToHistory(word: DataModel)
    suspend fun getWordFromLocalStorage(word: String): DataModel

}