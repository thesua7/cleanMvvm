package com.thesua7.cleanmvvm.domain.repository

import com.thesua7.cleanmvvm.data.dto.Charecters

interface RickMortyRepository {
    suspend fun getCharecters(): Charecters
}