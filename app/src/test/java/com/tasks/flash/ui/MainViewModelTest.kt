package com.example.currencyhistory.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import com.example.currencyhistory.TestLifecycleOwner
import com.tasks.flash.dataSource.RepositorySource
import com.tasks.flash.ui.MainViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import javax.inject.Inject


@RunWith(JUnit4::class)
class MainViewModelTest {

    @Mock
    @Inject
    lateinit var mRepository: RepositorySource
    private lateinit var mainViewModel: MainViewModel
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mainViewModel = MainViewModel(this.mRepository)
    }

    @Test
    fun checkResponseListNotNullOrEmpty() {
        val testOwner = TestLifecycleOwner()
        testOwner.handleEvent(Lifecycle.Event.ON_CREATE)
        mainViewModel.notifyUpdate.observe(testOwner, androidx.lifecycle.Observer {
            Assert.assertTrue(!mainViewModel.vehiclesList.isNullOrEmpty())
        })
        mainViewModel.getVehicles()
    }
}
