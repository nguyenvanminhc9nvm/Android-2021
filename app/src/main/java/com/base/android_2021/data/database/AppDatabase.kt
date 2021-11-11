package com.base.android_2021.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.base.android_2021.data.database.dao.UserDao
import com.base.android_2021.data.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract val userDao: UserDao
}
