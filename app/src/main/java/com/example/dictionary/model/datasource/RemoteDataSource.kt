package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.AppState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiHolder: ApiHolder)
    : RemoteDataSourceInterface {

    override fun getDataFromRemoteSource(word: String): Observable<AppState> {
        return apiHolder.api.search(word)
            .subscribeOn(Schedulers.io())
            .map { AppState.Success(it) }
    }
}