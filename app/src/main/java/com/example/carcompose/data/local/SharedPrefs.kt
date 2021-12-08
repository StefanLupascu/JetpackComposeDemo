package com.example.carcompose.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val DEMO_MODE = "DEMO_MODE_TAG"

class SharedPrefs @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs =
        context.getSharedPreferences("com.example.carcompose_preferences", Context.MODE_PRIVATE)

    fun getDemoMode() = prefs.getBoolean(DEMO_MODE, true)

    fun setDemoMode(isDemoMode: Boolean) {
        prefs.edit().putBoolean(DEMO_MODE, isDemoMode).apply()
    }
}