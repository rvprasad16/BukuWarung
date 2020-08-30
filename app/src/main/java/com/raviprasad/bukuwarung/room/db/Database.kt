package com.raviprasad.bukuwarung.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raviprasad.bukuwarung.room.dao.UserDao
import com.raviprasad.bukuwarung.room.entity.Data

@Database(entities = arrayOf(Data::class),version = 1)
abstract class Database : RoomDatabase() {
    abstract fun userDao(): UserDao?
}