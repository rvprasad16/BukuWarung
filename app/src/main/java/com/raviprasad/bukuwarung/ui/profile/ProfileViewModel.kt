package com.raviprasad.bukuwarung.ui.profile

import android.app.Application
import android.content.Context
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.raviprasad.bukuwarung.Repository
import com.raviprasad.bukuwarung.room.entity.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel : AndroidViewModel {

    private var reposotory: Repository
    private var context: Context
    var progressBarvisibility  = ObservableBoolean(false)
    var profilePresenter : ProfilePresenter?=null

    constructor(application: Application):super(application){
        reposotory= Repository(application.applicationContext)
        this.context = application.applicationContext
    }

    var firstName=""
    var lastName=""
    var email=""

    fun onSubmit(view: View){
        viewModelScope.launch {
            progressBarvisibility.set(true)
            var id=(100..100000).random()
            withContext(Dispatchers.IO){
                reposotory.addUser(Data(id,email,firstName,lastName,""))
            }
            progressBarvisibility.set(false)
            profilePresenter?.goToHome()
        }
    }


}