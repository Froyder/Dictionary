package com.example.dictionary.model.datasource

import android.annotation.SuppressLint
import com.example.dictionary.model.data.AppState
import com.example.dictionary.networkstatus.NetworkStatusInterface
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class DataProvider @Inject constructor(
    private val networkStatus: NetworkStatusInterface,
    private val remoteDataSource: RemoteDataSourceInterface,
    private val localDataSource: LocalDataSourceInterface
) : DataProviderInterface {

    private var isOnline = false

    override fun getDataFromSource(word: String): Observable<AppState> {
        getNetworkStatus()
        return if (isOnline) {
            remoteDataSource.getDataFromRemoteSource(word)
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