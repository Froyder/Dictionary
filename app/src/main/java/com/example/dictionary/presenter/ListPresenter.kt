package com.example.dictionary.presenter

import com.example.dataprovider.DataProviderInterface
import com.example.dictionary.view.ListFragmentView
import com.example.model.AppState
import com.example.model.DataModel
import dagger.assisted.AssistedInject
import kotlinx.coroutines.*
import timber.log.Timber

class ListPresenter @AssistedInject constructor(
    private val dataProvider: DataProviderInterface,
    private val currentView: ListFragmentView
) : MainPresenterInterface {

    private val viewModelScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    private var job: Job? = null

    override fun getData(word: String) {
        job?.cancel()
        job = viewModelScope.launch {
            val dataList = dataProvider.getDataFromSource(word)
            setData(dataList)
        }
    }

    override fun setData(dataList: List<DataModel>) {
        currentView.renderData(AppState.Success(dataList))
    }

    override fun handleError(error: Throwable) {
        currentView.renderData(AppState.Error(error))
        Timber.i("Timber talks: An error occurred: $error")
    }
}