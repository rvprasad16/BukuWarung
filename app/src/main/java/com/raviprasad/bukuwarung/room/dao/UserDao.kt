package com.raviprasad.bukuwarung.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raviprasad.bukuwarung.room.entity.Data


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(userdata: Data)

    @Query("SELECT * FROM user")
    fun getUser(): Array<Data?>?
}