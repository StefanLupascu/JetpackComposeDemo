package com.example.carcompose.data.local

import android.util.Log
import com.example.carcompose.data.model.CarDataSource
import com.example.carcompose.data.remote.CarService
import com.example.carcompose.utils.wrapIntoResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val service: CarDataSource
) : CarRepository {

    override suspend fun getCars() = withContext(Dispatchers.IO) {
        Log.e("DEBUG", "Service ${service.javaClass} getCars")
        wrapIntoResult { service.getCars() }
    }

    override suspend fun getCar(id: Long) = withContext(Dispatchers.IO) {
        wrapIntoResult { service.getCar(id) }
    }
}