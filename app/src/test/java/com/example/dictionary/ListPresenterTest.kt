package com.example.dictionary

import com.example.dataprovider.DataProvider
import com.example.dictionary.presenter.ListPresenter
import com.example.dictionary.presenter.MainPresenterInterface
import com.example.dictionary.view.ListFragmentView
import com.example.model.AppState
import com.example.model.DataModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ListPresenterTest {

    private lateinit var presenters: MainPresenterInterface

    @Mock
    private lateinit var dataProvider: DataProvider

    @Mock
    private lateinit var currentView: ListFragmentView

    private val dataList = listOf(Mockito.mock(DataModel::class.java))

    private val throwable = Throwable("error")
    private val request = "word"

    @DelicateCoroutinesApi
    private val testScope = GlobalScope

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenters = ListPresenter(dataProvider, currentView)
    }

    @DelicateCoroutinesApi
    @Test
    fun listPresenter_GetData_Test() {
        testScope.launch {
            presenters.getData(request)

            Mockito.verify(dataProvider, Mockito.times(1)).getDataFromSource(request)
        }
    }

    @DelicateCoroutinesApi
    @Test
    fun listPresenter_SetData_Error_Test() {
        testScope.launch {
            Mockito.`when`(dataList.isEmpty()).thenReturn(true)

            presenters.setData(dataList)
            Mockito.verify(currentView, Mockito.times(1)).renderData(AppState.Error(throwable))
        }
    }

    @DelicateCoroutinesApi
    @Test
    fun listPresenter_SetData_Loading_Test() {
        testScope.launch {
            Mockito.`when`(dataList.isEmpty()).thenReturn(true)

            presenters.setData(dataList)
            Mockito.verify(currentView, Mockito.times(1)).renderData(AppState.Loading(anyInt()))
        }
    }

    @DelicateCoroutinesApi
    @Test
    fun listPresenter_SetData_Success_Test() {
        testScope.launch {
            Mockito.`when`(dataList.isEmpty()).thenReturn(false)

            presenters.setData(dataList)
            Mockito.verify(currentView, Mockito.times(1)).renderData(AppState.Success(dataList))
        }
    }

    @Test
    fun handleError_Test() {
        presenters.handleError(throwable)
        Mockito.verify(currentView, Mockito.times(1)).renderData(AppState.Error(throwable))
    }
}