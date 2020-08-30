package com.raviprasad.bukuwarung.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("page")
    var page: Long,
    @SerializedName("per_page")
    var per_page: Long,
    @SerializedName("total")
    var total: Long,
    @SerializedName("total_page")
    var total_pages : Long,
    @SerializedName("data")
    var data : Array<Data>,
    @SerializedName("ad")
    var ad : Ad
)

data class Ad(
    @SerializedName("company")
    var company : String,
    @SerializedName("url")
    var url : String,
    @SerializedName("text")
    var text : String
)