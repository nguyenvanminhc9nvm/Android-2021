package com.base.android_2021.data.networking

import com.base.android_2021.data.networking.model.request.LoginRequest
import com.base.android_2021.data.networking.model.response.LoginResponse

interface ApiHelper {
    suspend fun doLogin(loginRequest: LoginRequest): LoginResponse
}