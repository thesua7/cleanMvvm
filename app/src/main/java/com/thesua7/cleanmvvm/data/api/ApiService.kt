package com.thesua7.cleanmvvm.data.api

import com.thesua7.cleanmvvm.data.dto.Charecters
import com.thesua7.cleanmvvm.util.Constants
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getCharecters():Charecters

}