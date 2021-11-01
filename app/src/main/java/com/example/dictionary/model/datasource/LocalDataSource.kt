package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.AppState
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.data.Meanings
import com.example.dictionary.model.data.Translation
import io.reactivex.Observable

class LocalDataSource: LocalDataSourceInterface {

    override fun getDataFromLocalSource(): Observable<AppState> {
        return Observable.just(AppState.Success(list))
    }

    private val list : List<DataModel> = listOf(
        DataModel("one", listOf(
            Meanings(Translation("раз"),"URL"),
        )),
        DataModel("two", listOf(
            Meanings(Translation("два"),"URL")
        )),
        DataModel("three", listOf(
            Meanings(Translation("три"),"URL")
        )),
        DataModel("four", listOf(
            Meanings(Translation("четыре"),"URL")
        )),
        DataModel("five", listOf(
            Meanings(Translation("пять"),"URL")
        )),
        DataModel("six", listOf(
            Meanings(Translation("шесть"),"URL")
        ))

    )

}