package com.example.dictionary.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dataprovider.DataProviderInterface
import com.example.model.AppState
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import timber.log.Timber

class ListFragmentViewModel (private val dataProvider: DataProviderInterface) : ViewModel(), KoinComponent {

    private val _mutableLiveData = MutableLiveData<AppState>()
    val mutableLiveData: LiveData<AppState>
        get() = _mutableLiveData

    private val viewModelScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    private var job: Job? = null

    fun getData(word: String) {
        _mutableLiveData.value = AppState.Loading(null)

        job?.cancel()
        job = viewModelScope.launch {
            val dataList = dataProvider.getDataFromSource(word)
            _mutableLiveData.postValue(AppState.Success(dataList))
        }
    }

    private fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
        Timber.i("Timber talks: An error occurred: $error")
    }

    override fun onCleared() {
        super.onCleared()
        _mutableLiveData.value = AppState.Success(null)
        viewModelScope.cancel()
    }
}