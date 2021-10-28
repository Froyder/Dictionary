package com.example.dictionary.presenter

import com.example.dictionary.model.datasource.DataProviderInterface
import com.example.dictionary.view.ListFragment
import com.example.dictionary.view.ListFragmentView
import dagger.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class ListPresenter @AssistedInject constructor(
    private val listView: ListFragment,
    private val dataProvider: DataProviderInterface
) : ListPresenterInterface {

    private var currentView: ListFragmentView? = null

    override fun onAttach () {
        if (listView != currentView) {
            currentView = listView
        }
    }

    private val compositeDisposable = CompositeDisposable()

    override fun getData(word: String) {
        compositeDisposable.addAll(
            dataProvider.getDataFromSource(word)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                        listView.renderData(it) },
                    {
                        println("An error occurred: $it")
                    })
        )
    }

    override fun onDetach() {
        compositeDisposable.clear()
        if (listView == currentView) {
            currentView = null
        }
    }
}