package com.raviprasad.bukuwarung.model

import com.google.gson.annotations.SerializedName
import com.raviprasad.bukuwarung.room.entity.Data

data class User (
    @SerializedName("page")
    var page: Long?,
    @SerializedName("per_page")
    var per_page: Long?,
    @SerializedName("total")
    var total: Long?,
    @SerializedName("total_page")
    var total_pages : Long?,
    @SerializedName("data")
    var data : MutableList<Data>?,
    @SerializedName("ad")
    var ad : Ad?
)

data class Ad(
    @SerializedName("company")
    var company : String,
    @SerializedName("url")
    var url : String,
    @SerializedName("text")
    var text : String
)