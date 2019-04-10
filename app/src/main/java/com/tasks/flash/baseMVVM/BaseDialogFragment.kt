package com.tasks.flash.baseMVVM

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.tasks.flash.App
import com.tasks.flash.dataSource.RepositorySource
import com.tasks.flash.dataSource.pref.AppPreferencesHelper
import javax.inject.Inject

abstract class BaseDialogFragment : DialogFragment() {

	val TAG = this.javaClass.simpleName

	lateinit var factory: FactoryGenerator

	@Inject
	lateinit var mRepo: RepositorySource

	@Inject
	lateinit var mSharedPrf: AppPreferencesHelper

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		App.instance.component.inject(this)
		factory = FactoryGenerator(mRepo, mSharedPrf)
	}

	override fun onStart() {
		super.onStart()
		dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
	}
}