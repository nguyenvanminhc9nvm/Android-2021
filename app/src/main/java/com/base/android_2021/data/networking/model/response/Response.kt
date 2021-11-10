package com.base.android_2021.data.networking.model.response

import com.google.gson.annotations.SerializedName

open class Response<T> {
    @SerializedName("success")
    var status: Int? = null

    @SerializedName("data")
    var data: T? = null

    @SerializedName("errors")
    var error: ErrorResponse? = null

    fun isSuccess(): Boolean {
        if (status == null) return false
        return status == 1
    }
}

class ListResponse<T> {
    @SerializedName("list")
    var list: MutableList<T>? = null
}

class ErrorResponse : Throwable() {
    @SerializedName("error_code")
    var errorCode: String? = null

    @SerializedName("error_message")
    var errorMessage: String? = null

    override fun getLocalizedMessage(): String {
        return errorMessage ?: "unknown error"
    }
}

class LoginResponse: Response<SignIn>()