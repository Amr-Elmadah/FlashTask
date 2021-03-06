package com.tasks.flash.baseMVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tasks.flash.dataSource.RepositorySource
import com.tasks.flash.dataSource.pref.AppPreferencesHelper
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class FactoryGenerator @Inject constructor(
    private val mRepo: RepositorySource,
    private val mSharedPrf: AppPreferencesHelper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(
                RepositorySource::class.java
            ).newInstance(mRepo) as T
        }
        throw IllegalArgumentException("unexpected model class $modelClass")
    }
}
