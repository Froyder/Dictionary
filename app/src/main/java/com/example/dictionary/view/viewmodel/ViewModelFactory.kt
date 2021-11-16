package com.example.dictionary.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dataprovider.DataProviderInterface
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val dataProvider: com.example.dataprovider.DataProviderInterface) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(com.example.dataprovider.DataProviderInterface::class.java)
            .newInstance(dataProvider)
    }

}