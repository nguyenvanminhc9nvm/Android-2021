package com.base.android_2021.data

import com.base.android_2021.data.data_store.DataStoreHelper
import com.base.android_2021.data.database.DbHelper
import com.base.android_2021.data.networking.ApiHelper
import com.base.android_2021.data.networking.model.request.LoginRequest
import com.base.android_2021.data.networking.model.response.LoginResponse
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val apiHelper: ApiHelper,
    private val dataStoreHelper: DataStoreHelper,
    private val dbHelper: DbHelper
) {
    suspend fun doLogin(loginRequest: LoginRequest): LoginResponse {
        return apiHelper.doLogin(loginRequest)
    }
}