package com.example.dictionary.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dictionary.model.datasource.DataProvider
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class DetailsViewModel: ViewModel(), KoinComponent{

    private val dataProvider: DataProvider by inject()

    private val viewModelScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    private var job: Job? = null

    fun addToFavorite(vararg arguments: String){
        job?.cancel()
        job = CoroutineScope(Dispatchers.IO).launch {
            dataProvider.addWordToFavorite(*arguments)
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