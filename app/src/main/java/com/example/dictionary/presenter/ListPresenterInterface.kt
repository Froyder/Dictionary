package com.example.dictionary.presenter

import com.example.dictionary.view.ListFragmentView

interface ListPresenterInterface {

    fun onAttach (listView: ListFragmentView)
    fun onDetach ()
    fun getData (word: String)

}