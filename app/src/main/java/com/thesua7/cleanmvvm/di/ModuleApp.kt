package com.thesua7.cleanmvvm.di

import com.thesua7.cleanmvvm.data.api.ApiService
import com.thesua7.cleanmvvm.data.repository.RickMortyRepositoryImp
import com.thesua7.cleanmvvm.domain.repository.RickMortyRepository
import com.thesua7.cleanmvvm.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ModuleApp {

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)


    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService):RickMortyRepository = RickMortyRepositoryImp(apiService)
}