package com.base.android_2021.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.base.android_2021.data.database.entity.User
import com.base.android_2021.utils.Constants

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM ${Constants.TB_USER}")
    suspend fun getUser(): MutableList<User>
}
