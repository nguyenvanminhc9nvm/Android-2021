package com.base.android_2021.data.database

import javax.inject.Inject

class AppDbHelper @Inject constructor(
    private val appDatabase: AppDatabase
): DbHelper {
}