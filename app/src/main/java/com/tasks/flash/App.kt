package com.tasks.flash

import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.squareup.leakcanary.LeakCanary
import com.tasks.flash.baseMVVM.ActivityLifecycleHandler
import com.tasks.flash.injection.AppComponent
import com.tasks.flash.injection.DaggerAppComponent
import com.tasks.flash.injection.context.ContextModule

@SuppressLint("ShowToast")
class App : Application() {
    lateinit var component: AppComponent
    private var mToast: Toast? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        mToast = Toast.makeText(applicationContext, null, Toast.LENGTH_LONG)
        component = DaggerAppComponent.builder().contextModule(ContextModule(this)).build()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        registerActivityLifecycleCallbacks(ActivityLifecycleHandler())
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    fun showToast(text: String) {
        if (mToast != null) {
            mToast?.cancel()
        }
        mToast = Toast.makeText(applicationContext, text, Toast.LENGTH_LONG)
        mToast?.show()
    }

    fun showToast(resID: Int) {
        if (mToast != null) {
            mToast?.cancel()
        }
        mToast = Toast.makeText(applicationContext, getString(resID), Toast.LENGTH_LONG)
        mToast?.show()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @get:Synchronized
        lateinit var instance: App
            private set
    }
}