package com.thesua7.cleanmvvm.data.repository

import com.thesua7.cleanmvvm.data.api.ApiService
import com.thesua7.cleanmvvm.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImp @Inject constructor(private val apiService: ApiService) :
    RickMortyRepository {
    override suspend fun getCharecters() = apiService.getCharecters()

}