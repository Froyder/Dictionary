package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.data.Meanings
import com.example.dictionary.model.data.Translation
import kotlinx.coroutines.*

class LocalDataSource : LocalDataSourceInterface {

    override suspend fun getDataFromLocalSource(): List<DataModel> {
        return returnLocalListAsync().await()
    }

    private fun returnLocalListAsync(): Deferred<List<DataModel>> =
        CoroutineScope(Dispatchers.IO).async {
            delay(DELAY_TIME)
            list
        }

    private val list: List<DataModel> = listOf(
        DataModel(
            "One", listOf(
                Meanings(Translation("один"), "URL"),
            )
        ),
        DataModel(
            "Two", listOf(
                Meanings(Translation("два"), "URL")
            )
        ),
        DataModel(
            "Three", listOf(
                Meanings(Translation("три"), "URL")
            )
        ),
        DataModel(
            "Four", listOf(
                Meanings(Translation("четыре"), "URL")
            )
        ),
        DataModel(
            "Five", listOf(
                Meanings(Translation("пять"), "URL")
            )
        ),
        DataModel(
            "Six", listOf(
                Meanings(Translation("шесть"), "URL")
            )
        )
    )

    companion object {
        private const val DELAY_TIME: Long = 1500
    }
}