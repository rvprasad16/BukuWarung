package com.raviprasad.bukuwarung.model

import com.google.gson.annotations.SerializedName

class Data (
    @SerializedName("id")
    var id : Long,
    @SerializedName("email")
    var email :String,
    @SerializedName("first_name")
    var first_name : String,
    @SerializedName("last_name")
    var last_name : String,
    @SerializedName("avatar")
    var avatar : String
)