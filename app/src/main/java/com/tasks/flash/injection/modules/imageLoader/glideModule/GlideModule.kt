package com.tasks.flash.injection.modules.imageLoader.glideModule

import android.content.Context
import com.bumptech.glide.Glide
import com.tasks.flash.injection.baseUrl.BaseUrlModule
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [BaseUrlModule::class])
class GlideModule {

	@Provides
	@Singleton
	fun providesGlide(context: Context) =
			Glide.with(context)

	@Provides
	@Singleton
	fun providesGlideImageLoader(glide: Glide, @Named(value = BaseUrlModule.DAGGER_CONSTANTS.BASE_URL) baseUrl: String): ImageLoader =
			GlideImageLoader(baseUrl)
}