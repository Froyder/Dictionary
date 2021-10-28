package com.example.dictionary.presenter

interface ListPresenterInterface {

    fun onAttach ()
    fun onDetach ()
    fun getData (word: String)

}