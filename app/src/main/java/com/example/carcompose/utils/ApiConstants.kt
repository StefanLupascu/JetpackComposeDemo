package com.example.carcompose.utils

object ApiConstants {

    const val BASE_URL = "http://192.168.0.150:8080/api/v1/"

    object CarsApi {
        const val ALL_CARS = "cars/all"
        const val CAR = "cars/{id}"
    }
}