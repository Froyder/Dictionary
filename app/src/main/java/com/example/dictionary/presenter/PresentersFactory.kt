package com.example.dictionary.presenter

import dagger.assisted.AssistedFactory

@AssistedFactory
interface PresentersFactory {

    fun createListPresenter (): ListPresenter

}