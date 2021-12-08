package com.example.carcompose.di

import com.example.carcompose.data.local.CarRepository
import com.example.carcompose.data.local.CarRepositoryImpl
import com.example.carcompose.data.local.SharedPrefs
import com.example.carcompose.data.model.CarDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideCarRepository(
        sharedPrefs: SharedPrefs,
        @AppModule.LocalDataSource mockService: CarDataSource,
        @AppModule.RemoteDataSource carService: CarDataSource
    ): CarRepository = CarRepositoryImpl(if (sharedPrefs.getDemoMode()) mockService else carService)
}