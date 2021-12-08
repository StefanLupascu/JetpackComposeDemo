package com.example.carcompose.data.local

import com.example.carcompose.data.model.CarBrand
import com.example.carcompose.data.model.CarDataSource
import com.example.carcompose.data.model.CarDto
import retrofit2.http.Path

class MockService : CarDataSource {

    private val carList = mutableListOf(
        CarDto(1, CarBrand.AUDI, "blue", 177, 2013, 13000),
        CarDto(2, CarBrand.BMW, "blue", 177, 2013, 13000),
        CarDto(3, CarBrand.AUDI, "blue", 177, 2013, 13000),
        CarDto(4, CarBrand.AUDI, "blue", 177, 2013, 13000),
        CarDto(5, CarBrand.BMW, "blue", 177, 2013, 13000),
        CarDto(6, CarBrand.MERCEDES_BENZ, "blue", 177, 2013, 13000),
        CarDto(8, CarBrand.MERCEDES_BENZ, "blue", 177, 2013, 13000),
        CarDto(7, CarBrand.MERCEDES_BENZ, "blue", 177, 2013, 13000),
        CarDto(9, CarBrand.BMW, "blue", 177, 2013, 13000),
        CarDto(4, CarBrand.AUDI, "blue", 177, 2013, 13000),
        CarDto(5, CarBrand.BMW, "blue", 177, 2013, 13000),
        CarDto(6, CarBrand.MERCEDES_BENZ, "blue", 177, 2013, 13000),
        CarDto(8, CarBrand.MERCEDES_BENZ, "blue", 177, 2013, 13000),
        CarDto(7, CarBrand.MERCEDES_BENZ, "blue", 177, 2013, 13000),
        CarDto(9, CarBrand.BMW, "blue", 177, 2013, 13000)
    )

    override suspend fun getCars() = carList

    override suspend fun getCar(@Path("id") id: Long) = carList.first { it.id == id }
}