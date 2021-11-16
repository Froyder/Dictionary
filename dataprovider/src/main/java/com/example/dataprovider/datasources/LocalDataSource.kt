package com.example.dataprovider.datasources

import com.example.database.DictionaryDatabase
import com.example.model.DataModel
import com.example.model.Meanings
import com.example.model.Translation
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalDataSource : LocalDataSourceInterface, KoinComponent {

    private val db: DictionaryDatabase by inject()
    private val dictionaryDao = db.dictionaryDao()

    override suspend fun getWordFromLocalStorage(word: String): DataModel {
        return dictionaryDao.getWordFromDB(word)
    }

    override suspend fun onLoadingDataError(): List<DataModel> {
        return listOf(DataModel(
            HEADER_ERROR_MESSAGE, listOf(
            Meanings(Translation(MAIN_ERROR_MESSAGE), URL_ERROR)
        )))
    }

    override suspend fun getFavoritesListFromLocalStorage(): List<DataModel> {
        return dictionaryDao.getFavoritesListFromDB()
    }

    override suspend fun getHistoryListFromDB(): List<DataModel> {
        return dictionaryDao.getWordListFromDB()
    }

    override suspend fun addListToLocalStorage(list: List<DataModel>) {
        dictionaryDao.updateList(list)
    }

    override suspend fun updateWordInDB(vararg arguments: String) {
        val text = arguments[0]
        val status = arguments[1]
        dictionaryDao.changeWordStatus(text, status)
    }

    companion object {
        private const val HEADER_ERROR_MESSAGE = "Loading error"
        private const val MAIN_ERROR_MESSAGE = "You are offline and there is no data for yor request in local storage"
        private const val URL_ERROR = ""
    }
}