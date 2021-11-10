package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.data.Meanings
import com.example.dictionary.model.data.Translation
import com.example.dictionary.model.datasource.LocalDataSource.Companion.MAIN_ERROR_MESSAGE
import com.example.dictionary.model.datasource.database.DictionaryDatabase
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalDataSource : LocalDataSourceInterface, KoinComponent {

    private val db: DictionaryDatabase by inject()
    private val dictionaryDao = db.dictionaryDao()

    override suspend fun addWordToHistory(word: DataModel) {
        dictionaryDao.updateWord(word)
    }

    override suspend fun getWordFromLocalStorage(word: String): DataModel {
        return dictionaryDao.getWordFromDB(word)
    }

    override suspend fun onLoadingDataError(): List<DataModel> {
        return listOf(DataModel(HEADER_ERROR_MESSAGE, listOf(
            Meanings(Translation(MAIN_ERROR_MESSAGE), URL_ERROR))))
    }

    companion object {
        private const val HEADER_ERROR_MESSAGE = "Loading error"
        private const val MAIN_ERROR_MESSAGE = "You are offline and there is no data for yor request in local storage"
        private const val URL_ERROR = ""
    }
}