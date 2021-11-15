package com.example.dictionary.presenter

import com.example.dictionary.view.ListFragmentView
import dagger.assisted.AssistedInject
import io.reactivex.disposables.CompositeDisposable

class ListPresenter @AssistedInject constructor(
    private val dataProvider: com.example.dataprovider.DataProviderInterface
) : ListPresenterInterface {

    private var currentView: ListFragmentView? = null

    override fun onAttach (listView: ListFragmentView) {
        currentView = listView
    }

    private val compositeDisposable = CompositeDisposable()

    override fun getData(word: String) {
//        compositeDisposable.addAll(
//            dataProvider.getDataFromSource(word)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe ({
//                    currentView?.renderData(it) },
//                    {
//                        println("An error occurred: $it")
//                    })
//        )
    }

    override fun onDetach() {
        compositeDisposable.clear()
        currentView = null
    }
}