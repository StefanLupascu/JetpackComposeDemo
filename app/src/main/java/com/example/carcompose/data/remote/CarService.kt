package com.example.carcompose.data.remote

import com.example.carcompose.data.model.CarDataSource
import com.example.carcompose.data.model.CarDto
import com.example.carcompose.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Path

interface CarService : CarDataSource {

    @GET(ApiConstants.CarsApi.ALL_CARS)
    override suspend fun getCars(): List<CarDto>

    @GET(ApiConstants.CarsApi.CAR)
    override suspend fun getCar(@Path("id") id: Long): CarDto
}