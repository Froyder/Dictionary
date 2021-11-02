package com.example.dictionary.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.model.data.AppState
import com.example.dictionary.model.datasource.DataProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class ListFragmentViewModel : ViewModel(), KoinComponent {

    private val dataProvider: DataProvider by inject()

    private val _mutableLiveData = MutableLiveData<AppState>()
    val mutableLiveData: LiveData<AppState>
    get() = _mutableLiveData

    private val compositeDisposable = CompositeDisposable()

    fun getData(word: String) {
        compositeDisposable.addAll(
            dataProvider.getDataFromSource(word)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    _mutableLiveData.postValue(it) },
                    {
                        Timber.i("Timber talks: An error occurred: $it")
                    })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}