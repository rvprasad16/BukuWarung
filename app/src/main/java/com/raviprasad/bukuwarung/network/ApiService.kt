package com.raviprasad.bukuwarung.network

import com.raviprasad.bukuwarung.model.User
import retrofit2.Response
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.USERS)
    suspend fun user() : Response<User>
}