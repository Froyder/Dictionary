package com.example.dataprovider.datasources

import com.example.model.DataModel

interface RemoteDataSourceInterface {

    suspend fun getDataFromRemoteSource(word: String) : List<DataModel>

}