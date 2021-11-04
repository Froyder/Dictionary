package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

interface LocalDataSourceInterface {

    suspend fun getDataFromLocalSource() : List<DataModel>

}