package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.AppState
import io.reactivex.Observable

interface LocalDataSourceInterface {

    fun getDataFromLocalSource() : Observable<AppState>

}