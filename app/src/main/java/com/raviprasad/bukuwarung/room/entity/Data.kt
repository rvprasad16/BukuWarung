package com.raviprasad.bukuwarung.room.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
class Data (
    @ColumnInfo(name="user_id")
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    var id : Int,

    @ColumnInfo(name="user_email")
    @SerializedName("email")
    var email :String,

    @ColumnInfo(name="user_first_name")
    @SerializedName("first_name")
    var first_name : String,

    @ColumnInfo(name="user_last_name")
    @SerializedName("last_name")
    var last_name : String,

    @ColumnInfo(name="user_avatar")
    @SerializedName("avatar")
    var avatar : String?
)