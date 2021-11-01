package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DataEndPoints {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModel>>
}