package com.thesua7.cleanmvvm.domain.usecase

import coil.network.HttpException
import com.thesua7.cleanmvvm.domain.model.RickMortyModel
import com.thesua7.cleanmvvm.domain.model.toDomain
import com.thesua7.cleanmvvm.domain.repository.RickMortyRepository
import com.thesua7.cleanmvvm.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class RickMortyUsecase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke() : Flow<Resource<List<RickMortyModel>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getCharecters().results.map{it.toDomain()}
            emit(Resource.Success(data))

        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error("Error"))
        }
    }
}