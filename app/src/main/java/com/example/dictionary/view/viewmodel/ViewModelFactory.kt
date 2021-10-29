package com.example.dictionary.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dictionary.model.datasource.DataProviderInterface
import javax.inject.Inject

class ViewModelFactory @Inject constructor (private val dataProvider: DataProviderInterface): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DataProviderInterface::class.java).newInstance(dataProvider)
    }

}