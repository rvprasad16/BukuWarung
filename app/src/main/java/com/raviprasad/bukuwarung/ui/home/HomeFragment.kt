package com.raviprasad.bukuwarung.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.raviprasad.bukuwarung.R
import com.raviprasad.bukuwarung.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        homeBinding.homeviewmodel=homeViewModel
        return homeBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel.featchUser()
        homeViewModel.getUserData().observe(viewLifecycleOwner, Observer {
                data->
            homeBinding.recyclerView.also {
                it.layoutManager = LinearLayoutManager(view?.context)
                it.adapter = context?.let { it1 ->
                    HomeAdapter(
                        it1,
                        data
                    )
                }
            }

        })
    }
}
