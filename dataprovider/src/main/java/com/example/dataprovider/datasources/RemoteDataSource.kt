package com.example.dataprovider.datasources

import com.example.dataprovider.ApiHolder
import com.example.model.DataModel


class RemoteDataSource (private val apiHolder: ApiHolder)
    : RemoteDataSourceInterface {

    override suspend fun getDataFromRemoteSource(word: String): List<DataModel> {
        return apiHolder.api.searchAsync(word).await()
    }
}