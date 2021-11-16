package com.example.dictionary.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dataprovider.DataProviderInterface
import com.example.model.DataModel
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import timber.log.Timber

class HistoryViewModel(private val dataProvider: DataProviderInterface): ViewModel(), KoinComponent {

    private val _mutableLiveData = MutableLiveData<List<DataModel>>()
    val mutableLiveData: LiveData<List<DataModel>>
        get() = _mutableLiveData

    private val viewModelScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    private var job: Job? = null

    fun init() {
        job?.cancel()
        job = CoroutineScope(Dispatchers.IO).launch {
            _mutableLiveData.postValue(dataProvider.getHistoryListFromLocalStorage())
        }
    }

    private fun handleError(error: Throwable) {
        Timber.i("Timber talks: An error occurred: $error")
    }

    override fun onCleared() {
        job?.cancel()
        viewModelScope.cancel()
        super.onCleared()
    }
}