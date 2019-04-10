package com.tasks.flash.dataSource.remoteDataSource

import com.tasks.flash.App
import com.tasks.flash.R

interface NetworkCallBacks {

    interface BaseNetworkCallBacks<ReturnType> {
        fun onSuccess(result: ReturnType)

        fun onError(err: String) {
            App.instance.showToast(err)
        }

        fun onNoInternetConnection() {
            App.instance.showToast(R.string.internet_connection)
        }
    }
}