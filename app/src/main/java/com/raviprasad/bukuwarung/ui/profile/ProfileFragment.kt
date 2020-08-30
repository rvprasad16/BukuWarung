package com.raviprasad.bukuwarung.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.raviprasad.bukuwarung.MainActivity
import com.raviprasad.bukuwarung.R
import com.raviprasad.bukuwarung.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(), ProfilePresenter {

    private lateinit var dashboardViewModel: ProfileViewModel
    private lateinit var profileBinding : FragmentProfileBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(ProfileViewModel::class.java)
        profileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        profileBinding.profilebinding=dashboardViewModel
        dashboardViewModel.profilePresenter=this

        return profileBinding.root
    }

    override fun goToHome() {
        var i=Intent(view?.context,MainActivity::class.java)
        Toast.makeText(view?.context,"Done",Toast.LENGTH_SHORT).show()
        startActivity(i)
        activity?.finish()

    }
}
