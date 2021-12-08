package com.example.carcompose.ui.landing

import androidx.lifecycle.ViewModel
import com.example.carcompose.data.local.SharedPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val sharedPrefs: SharedPrefs
): ViewModel() {

    fun setDemoMode(isDemoMode: Boolean) = sharedPrefs.setDemoMode(isDemoMode)
}