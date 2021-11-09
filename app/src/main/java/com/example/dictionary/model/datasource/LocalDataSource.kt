package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.data.Meanings
import com.example.dictionary.model.data.Translation
import com.example.dictionary.model.datasource.database.DictionaryDatabase
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalDataSource : LocalDataSourceInterface, KoinComponent {

    private val db: DictionaryDatabase by inject()
    private val dictionaryDao = db.dictionaryDao()

    override suspend fun getDataFromLocalSource(): List<DataModel> {
        return returnLocalListAsync().await()
    }

    override suspend fun addWordToHistory(word: DataModel) {
        dictionaryDao.updateWord(word)
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