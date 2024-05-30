package com.thesua7.cleanmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesua7.cleanmvvm.domain.usecase.RickMortyUsecase
import com.thesua7.cleanmvvm.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickMortyViewmodel @Inject constructor(private val usecase: RickMortyUsecase) : ViewModel() {

    private val _state = MutableStateFlow(RickMortyStates())
    val state:MutableStateFlow<RickMortyStates> = _state

    init {
        getItems()
    }

    private fun getItems() = viewModelScope.launch(Dispatchers.IO) {
        usecase().collect{
            when(it){
                is Resource.Success -> _state.value = RickMortyStates(success = it.data?: emptyList())
                is Resource.Error -> _state.value = RickMortyStates(fail = it.message?: "Error")
                is Resource.Loading -> _state.value = RickMortyStates(isLoading = true)
            }

        }
    }




}