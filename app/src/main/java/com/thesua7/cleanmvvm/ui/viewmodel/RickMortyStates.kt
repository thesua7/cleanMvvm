package com.thesua7.cleanmvvm.ui.viewmodel

import com.thesua7.cleanmvvm.domain.model.RickMortyModel

data class RickMortyStates(
    val isLoading: Boolean = false,
    val success: List<RickMortyModel> = emptyList(),
    val fail: String = ""
)
