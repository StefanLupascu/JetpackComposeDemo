package com.example.carcompose.data.model

interface CarDataSource {

    suspend fun getCars(): List<CarDto>

    suspend fun getCar(id: Long): CarDto
}