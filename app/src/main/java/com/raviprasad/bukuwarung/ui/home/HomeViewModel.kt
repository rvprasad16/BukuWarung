package com.raviprasad.bukuwarung.ui.home

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.raviprasad.bukuwarung.Repository
import com.raviprasad.bukuwarung.room.entity.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : AndroidViewModel {

    private var reposotory: Repository
    private var context: Context
    var progressBarvisibility  = ObservableBoolean(false)

    constructor(application: Application):super(application){
        reposotory= Repository(application.applicationContext)
        this.context = application.applicationContext
    }

    private var userData = MutableLiveData<List<Data>>()


    fun getUserData() : LiveData<List<Data>>{
        return userData
    }

    fun featchUser(){
        progressBarvisibility.set(true)
        var data : MutableList<Data>?
        viewModelScope.launch {
               withContext(Dispatchers.IO){
                   data = reposotory.getUser()
               }
            if(data!=null){
                userData.value=data
            }
            progressBarvisibility.set(false)
        }
    }
}