package com.raviprasad.bukuwarung.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class UserProfileViewModel(application: Application) : AndroidViewModel(application) {

    var first_name =""
    var last_name=""
    var email= ""

    fun setData(fn :String,ln:String,e:String){
        first_name=fn;
        last_name=ln
        email=e
    }
}