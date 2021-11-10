package com.base.android_2021.data.networking

import com.base.android_2021.data.networking.model.request.LoginRequest
import com.base.android_2021.data.networking.model.response.LoginResponse
import javax.inject.Inject

class AppApiHelper @Inject constructor(
    private val apiService: ApiService
): ApiHelper {
    override suspend fun doLogin(loginRequest: LoginRequest): LoginResponse {
        return apiService.doLogin(loginRequest)
    }
}