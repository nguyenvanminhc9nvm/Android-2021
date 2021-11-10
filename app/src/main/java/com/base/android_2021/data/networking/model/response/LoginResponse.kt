package com.base.android_2021.data.networking.model.response

import com.google.gson.annotations.SerializedName

data class SignIn(
    @SerializedName("access_token") val accessToken: String?,
    @SerializedName("token_type") val tokenType: String?,
    @SerializedName("expires_in") val expiresIn: Int?
)