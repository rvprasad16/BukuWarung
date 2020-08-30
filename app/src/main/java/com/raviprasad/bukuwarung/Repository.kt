package com.raviprasad.bukuwarung

import android.content.Context
import androidx.room.Room
import com.raviprasad.bukuwarung.model.User
import com.raviprasad.bukuwarung.network.RetrofitInstance
import com.raviprasad.bukuwarung.room.db.Database
import com.raviprasad.bukuwarung.room.entity.Data


class Repository {
    private var context: Context
    private var database : Database

    constructor(context: Context){
        this.context = context
        database = Room.databaseBuilder(context, Database::class.java, "courseDB").build()
    }
    var service= RetrofitInstance()

    suspend fun user() : Array<Data>? {
        var userData =service.getApiService().user().body()
        var userList = mutableListOf<Data>()
        if(userData!=null){
            //add data to room and send data from room
            for (i in userData.data!!)
                database.userDao()!!.addUser(i)
            userList.addAll(database.userDao()!!.getUser() as Collection<Data>)
        }else{
            //send data form room
            userList.addAll(database.userDao()!!.getUser() as Collection<Data>)
        }
        return userList as Array<Data>
    }

}