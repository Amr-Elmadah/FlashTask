package com.tasks.flash.ui

import android.os.Bundle
import com.tasks.flash.R
import com.tasks.flash.baseMVVM.BaseActivity
import com.tasks.flash.extension.addFragment

class MainActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_maps)

		addFragment(MainFragment.newInstance(), R.id.main_container)
	}
}
