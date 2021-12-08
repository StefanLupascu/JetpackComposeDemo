package com.example.carcompose.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcompose.data.local.CarRepository
import com.example.carcompose.data.model.CarDto
import com.example.carcompose.utils.CarResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CarRepository
) : ViewModel() {

    private val _carsLiveData = MutableLiveData<List<CarDto>>()
    val carsLiveData: LiveData<List<CarDto>> get() = _carsLiveData

    private val carList = mutableListOf<CarDto>()

    init {
        getCars()
    }

    private fun getCars() {
        viewModelScope.launch {
            when (val result = repository.getCars()) {
                is CarResult.Success -> {
                    carList.apply {
                        clear()
                        addAll(result.value)
                    }
                    _carsLiveData.postValue(result.value)
                }
                else -> {
                    // Handle error
                }
            }
        }
    }
}