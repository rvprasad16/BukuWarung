package com.raviprasad.bukuwarung

import android.content.Context
import com.raviprasad.bukuwarung.model.User
import com.raviprasad.bukuwarung.network.RetrofitInstance

class Repository {
    private var context: Context

    constructor(context: Context){
        this.context = context
    }
    var service= RetrofitInstance()

    suspend fun user() : User? {
        var userData =service.getApiService().user().body()
        if(userData!=null){
            //add data to room and send data from room
        }else{
            //send data form room
        }
        return userData
    }

}