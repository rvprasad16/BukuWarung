package com.raviprasad.bukuwarung.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raviprasad.bukuwarung.R
import com.raviprasad.bukuwarung.databinding.LayoutUserBinding
import com.raviprasad.bukuwarung.room.entity.Data

class HomeAdapter(var context : Context,var data : List<Data> ) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  ViewHolder (
        DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.layout_user,parent,false)

    )

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBinding.userlayout = data.get(position)
        Glide.with(context).load(data.get(position).avatar).into(holder.dataBinding.imageView)

    }

    inner class  ViewHolder(var dataBinding : LayoutUserBinding) :RecyclerView.ViewHolder(dataBinding.root)


}