package com.tasks.flash.dataSource.remoteDataSource.retrofit.services

import com.tasks.flash.model.Vehicle
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

	@GET("vehicles")
	fun getVehicles(): Call<List<Vehicle>>
}