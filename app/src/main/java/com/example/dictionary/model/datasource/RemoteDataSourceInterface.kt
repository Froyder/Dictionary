package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.AppState
import io.reactivex.Observable

interface RemoteDataSourceInterface {

    fun getDataFromRemoteSource(word: String) : Observable<AppState>

}