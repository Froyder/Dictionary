package com.example.dictionary.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.model.data.AppState
import com.example.dictionary.model.datasource.DataProviderInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor
    (private val dataProvider: DataProviderInterface) : ViewModel() {

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