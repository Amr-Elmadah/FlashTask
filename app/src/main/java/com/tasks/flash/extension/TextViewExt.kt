package com.tasks.flash.extension

import android.widget.TextView

val TextView.textString: String
	get() = text.toString()
