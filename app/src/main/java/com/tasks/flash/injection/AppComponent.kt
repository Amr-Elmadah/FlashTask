package com.tasks.flash.injection

import com.tasks.flash.baseMVVM.BaseActivity
import com.tasks.flash.baseMVVM.BaseDialogFragment
import com.tasks.flash.baseMVVM.BaseFragment
import com.tasks.flash.dataSource.RepositorySourceModule
import com.tasks.flash.dataSource.remoteDataSource.RemoteDataSourceModule
import com.tasks.flash.injection.baseUrl.BaseUrlModule
import com.tasks.flash.injection.context.ContextModule
import com.tasks.flash.injection.modules.cacheModule.CacheModule
import com.tasks.flash.injection.modules.database.PrefModule
import com.tasks.flash.injection.modules.imageLoader.glideModule.GlideModule
import com.tasks.flash.injection.modules.jsonParser.gsonModule.GsonModule
import com.tasks.flash.injection.modules.okhttpclient.OkhttpClientModule
import com.tasks.flash.injection.modules.retrofitModule.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        BaseUrlModule::class,
        ContextModule::class,
        CacheModule::class,
        PrefModule::class,
        GlideModule::class,
        GsonModule::class,
        OkhttpClientModule::class,
        RetrofitModule::class,
        RepositorySourceModule::class,
        RemoteDataSourceModule::class
    ]
)

interface AppComponent {
    fun inject(baseFragment: BaseFragment)
    fun inject(baseActivity: BaseActivity)
    fun inject(baseDialogFragment: BaseDialogFragment)
}
