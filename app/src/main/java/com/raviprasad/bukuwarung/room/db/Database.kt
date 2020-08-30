package com.raviprasad.bukuwarung.room.db

import androidx.room.RoomDatabase
import com.raviprasad.bukuwarung.room.dao.UserDao

abstract class Database : RoomDatabase() {
    abstract fun userDao(): UserDao?
}