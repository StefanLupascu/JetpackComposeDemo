package com.example.carcompose.data.local

import com.example.carcompose.data.model.CarDto
import com.example.carcompose.utils.CarResult

interface CarRepository {

    suspend fun getCars(): CarResult<List<CarDto>>

    suspend fun getCar(id: Long): CarResult<CarDto>
}