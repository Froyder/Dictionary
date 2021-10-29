package com.example.dictionary.view

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.dictionary.model.datasource.DataProvider
import com.example.dictionary.networkstatus.NetworkStatusInterface
import com.example.dictionary.presenter.PresentersFactory
import com.example.dictionary.view.viewmodel.ViewModelFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var appContext: Context
    @Inject
    lateinit var networkStatus: NetworkStatusInterface
    @Inject
    lateinit var dataProvider: DataProvider
    @Inject
    lateinit var presentersFactory: PresentersFactory
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

}