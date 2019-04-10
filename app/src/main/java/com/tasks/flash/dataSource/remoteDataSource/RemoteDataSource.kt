package com.tasks.flash.dataSource.remoteDataSource

import com.tasks.flash.model.Vehicle

interface RemoteDataSource {
    fun getVehicles(callBacks: NetworkCallBacks.BaseNetworkCallBacks<List<Vehicle>>)
}