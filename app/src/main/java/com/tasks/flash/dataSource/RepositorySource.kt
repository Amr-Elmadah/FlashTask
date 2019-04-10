package com.tasks.flash.dataSource

import com.tasks.flash.dataSource.localDataSourse.LocalDataSource
import com.tasks.flash.dataSource.remoteDataSource.RemoteDataSource

interface RepositorySource : RemoteDataSource, LocalDataSource