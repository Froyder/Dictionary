package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

class RemoteDataSource (private val apiHolder: ApiHolder)
    : RemoteDataSourceInterface {

    override suspend fun getDataFromRemoteSource(word: String): List<DataModel> {
        return apiHolder.api.searchAsync(word).await()
    }
}