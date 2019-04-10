package com.tasks.flash.dataSource

import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import com.tasks.flash.dataSource.remoteDataSource.NetworkCallBacks
import com.tasks.flash.dataSource.remoteDataSource.RemoteDataSource
import com.tasks.flash.model.Vehicle
import kotlin.concurrent.thread

class DataSource constructor(
    private val mGson: Gson,
    private val mRemoteDataSource: RemoteDataSource
) : RepositorySource {
    private val TAG = "C.DataSource"

    private lateinit var mHandler: Handler
    private val mThreadLocal: Thread

    init {
        mThreadLocal = thread {
            //the looper is due to the fact that the
            //threads in java is design to run on job
            //for only one time, the looper will just
            // keep.. well, "looping" the thread.
            Looper.prepare()
            mHandler = Handler()
            Looper.loop()
        }
    }

    override fun clearDataBase() {
    }

    override fun getVehicles(callBacks: NetworkCallBacks.BaseNetworkCallBacks<List<Vehicle>>) {
        mHandler.post {
            mRemoteDataSource.getVehicles(callBacks)
        }
    }
}