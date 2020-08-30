package com.raviprasad.bukuwarung.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private lateinit var apiService: ApiService

    fun getApiService():ApiService{
        if(!::apiService.isInitialized){
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiService=retrofit.create(ApiService::class.java)
        }
        return apiService
    }
}