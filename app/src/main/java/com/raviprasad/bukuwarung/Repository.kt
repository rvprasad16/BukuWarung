package com.raviprasad.bukuwarung

import android.content.Context
import android.util.Log
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

    suspend fun getUser() : MutableList<Data>? {
        var userList = mutableListOf<Data>()
        try {
            var check = service.getApiService().user();

        var userData =check.body()

        if(userData!=null){
            for (i in userData.data!!)
                database.userDao()!!.addUser(i)
            userList.addAll(database.userDao()!!.getUser() as Collection<Data>)
        }else{
            userList.addAll(database.userDao()!!.getUser() as Collection<Data>)
        }
        }catch (e :Exception){
            userList.addAll(database.userDao()!!.getUser() as Collection<Data>)
        }

        return userList

    }

    suspend fun addUser(data :Data){
        database.userDao()!!.addUser(data)
    }

}