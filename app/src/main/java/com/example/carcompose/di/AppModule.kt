package com.example.carcompose.di

import android.content.Context
import android.content.SharedPreferences
import com.example.carcompose.data.local.CarRepository
import com.example.carcompose.data.local.CarRepositoryImpl
import com.example.carcompose.data.local.MockService
import com.example.carcompose.data.local.SharedPrefs
import com.example.carcompose.data.model.CarDataSource
import com.example.carcompose.data.remote.CarService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalDataSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteDataSource

    @Singleton
    @LocalDataSource
    @Provides
    fun provideMockService(): CarDataSource = MockService()

    @Singleton
    @RemoteDataSource
    @Provides
    fun provideCarService(retrofit: Retrofit): CarDataSource =
        retrofit.create(CarService::class.java)

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) = SharedPrefs(context)
}