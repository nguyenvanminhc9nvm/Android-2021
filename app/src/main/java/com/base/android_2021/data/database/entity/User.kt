package com.base.android_2021.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.base.android_2021.utils.Constants

@Entity(tableName = Constants.TB_USER)
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "user_name")
    val userName: String
)
