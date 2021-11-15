package com.example.dataprovider

import android.annotation.SuppressLint
import com.example.dataprovider.datasources.LocalDataSourceInterface
import com.example.dataprovider.datasources.RemoteDataSourceInterface
import com.example.utils.networkStatus.NetworkStatusInterface
import com.example.model.DataModel
import timber.log.Timber

class DataProvider (
    private val networkStatus: NetworkStatusInterface,
    private val remoteDataSource: RemoteDataSourceInterface,
    private val localDataSource: LocalDataSourceInterface
) : DataProviderInterface {

    private var isOnline = false

    private lateinit var list: List<DataModel>

    override suspend fun getDataFromSource(word: String): List<DataModel> {
        list = listOf(localDataSource.getWordFromLocalStorage(word))
        return if (list[0] != null) {
            Timber.i(TIMBER_LOCAL_DATA)
            list
        } else tryToLoadRemoteData(word)
    }

    override suspend fun addWordToFavorite(vararg arguments: String) {
        localDataSource.updateWordInDB(*arguments)
    }

    override suspend fun getFavoritesList(): List<DataModel> {
        return localDataSource.getFavoritesListFromLocalStorage()
    }

    private suspend fun tryToLoadRemoteData(word: String): List<DataModel>{
        getNetworkStatus()
        return if (isOnline) {
            list = remoteDataSource.getDataFromRemoteSource(word)
            localDataSource.addListToLocalStorage(list)
            Timber.i(TIMBER_REMOTE_DATA)
            list
        } else {
            Timber.i(TIMBER_ERROR_MESSAGE)
            localDataSource.onLoadingDataError()
        }
    }

    override suspend fun getHistoryListFromLocalStorage(): List<DataModel>{
        return localDataSource.getHistoryListFromDB()
    }

    @SuppressLint("CheckResult")
    private fun getNetworkStatus() {
        networkStatus.isOnlineSingle()
            .subscribe({
                Timber.i("Timber talks: Your network status is $it!")
                isOnline = it
            },{
                Timber.i("Timber talks: An error occurred: $it")
                isOnline = false
            })
    }

    companion object {
        private const val TIMBER_ERROR_MESSAGE = "Timber talks: you are offline and there is no data for yor request in local storage"
        private const val TIMBER_LOCAL_DATA = "Timber talks: data was loaded from local storage"
        private const val TIMBER_REMOTE_DATA = "Timber talks: data was loaded from remote storage"
    }
}