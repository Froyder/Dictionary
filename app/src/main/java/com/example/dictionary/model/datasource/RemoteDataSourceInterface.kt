package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

interface RemoteDataSourceInterface {

    suspend fun getDataFromRemoteSource(word: String) : List<DataModel>

}