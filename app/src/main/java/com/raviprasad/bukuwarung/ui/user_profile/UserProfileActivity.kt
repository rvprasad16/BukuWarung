package com.raviprasad.bukuwarung.ui.user_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.raviprasad.bukuwarung.R
import com.raviprasad.bukuwarung.databinding.ActivityUserProfileBinding

class UserProfileActivity : AppCompatActivity() {
    private lateinit var viewModel: UserProfileViewModel
    private lateinit var viewBinding: ActivityUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_user_profile)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_user_profile)
        viewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        viewBinding.userprofile=viewModel
        var i=intent
        var first_name=i.getStringExtra("fname")
        var last_name=i.getStringExtra("lname")
        var email=i.getStringExtra("email")
        var image = i.getStringExtra("image")
        viewModel.setData(first_name!!,last_name!!,email!!)
        Glide.with(this).load(image).circleCrop().into(viewBinding.imageView)
    }
}
