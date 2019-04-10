package com.tasks.flash.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasks.flash.dataSource.RepositorySource
import com.tasks.flash.dataSource.remoteDataSource.NetworkCallBacks
import com.tasks.flash.model.Vehicle
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mRepo: RepositorySource) :
    ViewModel(), LifecycleObserver {

    val currencyList = mutableListOf<Vehicle>()
    val notifyUpdate = MutableLiveData<Boolean>()
    val notifyLoading = MutableLiveData<Boolean>()
    val notifyFinished = MutableLiveData<Boolean>()

    fun getVehicles() {
        notifyLoading.value = true
        mRepo.getVehicles(callBacks = object : NetworkCallBacks.BaseNetworkCallBacks<List<Vehicle>> {
            override fun onSuccess(result: List<Vehicle>) {
                currencyList.addAll(result)
                notifyUpdate.value = true
                notifyFinished.value = true
            }

            override fun onError(err: String) {
                super.onError(err)
                notifyFinished.value = true
            }

            override fun onNoInternetConnection() {
                super.onNoInternetConnection()
                notifyFinished.value = true
            }
        })
    }
}
