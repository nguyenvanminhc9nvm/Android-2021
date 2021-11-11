package com.base.android_2021.data.networking

import com.base.android_2021.data.networking.model.request.LoginRequest
import com.base.android_2021.data.networking.model.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun doLogin(@Body loginRequest: LoginRequest): LoginResponse

    @Headers()
    suspend fun doGetList()
}