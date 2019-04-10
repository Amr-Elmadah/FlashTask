package com.tasks.flash.dataSource.remoteDataSource

import com.tasks.flash.dataSource.remoteDataSource.retrofit.RemoteDataSourceUsingRetrofit
import com.tasks.flash.dataSource.remoteDataSource.retrofit.services.ApiService
import com.tasks.flash.dataSource.remoteDataSource.retrofit.services.ServicesModule
import com.tasks.flash.injection.modules.jsonParser.gsonModule.GsonModule
import com.tasks.flash.dataSource.remoteDataSource.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ServicesModule::class, GsonModule::class])
class RemoteDataSourceModule {
	@Provides
	@Singleton
	fun provideRemoteDataSource(
			apiClient: ApiService
	): RemoteDataSource = RemoteDataSourceUsingRetrofit(
			apiClient
	)
}