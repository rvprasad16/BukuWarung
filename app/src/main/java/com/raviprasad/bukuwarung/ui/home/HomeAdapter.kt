package com.raviprasad.bukuwarung.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raviprasad.bukuwarung.R
import com.raviprasad.bukuwarung.databinding.LayoutUserBinding
import com.raviprasad.bukuwarung.room.entity.Data
import com.raviprasad.bukuwarung.ui.UserProfileActivity

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
        holder.dataBinding.root.setOnClickListener { view ->
            var i = Intent(context,UserProfileActivity::class.java)
            i.putExtra("fname",data.get(position).first_name)
            i.putExtra("lname",data.get(position).last_name)
            i.putExtra("email",data.get(position).email)
            i.putExtra("image",data.get(position).avatar)
            context.startActivity(i)
        }

    }

    inner class  ViewHolder(var dataBinding : LayoutUserBinding) :RecyclerView.ViewHolder(dataBinding.root)


}