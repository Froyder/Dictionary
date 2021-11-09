package com.example.dictionary.model.datasource

import android.annotation.SuppressLint
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.networkstatus.NetworkStatusInterface
import timber.log.Timber

class DataProvider (
    private val networkStatus: NetworkStatusInterface,
    private val remoteDataSource: RemoteDataSourceInterface,
    private val localDataSource: LocalDataSourceInterface
) : DataProviderInterface {

    private var isOnline = false

    override suspend fun getDataFromSource(word: String): List<DataModel> {
        getNetworkStatus()
        return if (isOnline) {
            val list = remoteDataSource.getDataFromRemoteSource(word)
            localDataSource.addWordToHistory(list[0])
            list
        } else {
            localDataSource.getDataFromLocalSource()
        }
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

}