package com.tasks.flash.injection.modules.imageLoader.glideModule

import android.widget.ImageView

interface ImageLoader {

	fun loadImageInto(targetImageView: ImageView)

	fun loadImageInto(placeholderImageId: Int, targetImageView: ImageView)

	fun loadCircleImageInto(placeholderImageId: Int, targetImageView: ImageView)
}