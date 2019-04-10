package com.tasks.flash.extension

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.tasks.flash.R


class Loader(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE)
        setContentView(R.layout.common_progress)
        this.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        this.setCancelable(false)
    }
}
