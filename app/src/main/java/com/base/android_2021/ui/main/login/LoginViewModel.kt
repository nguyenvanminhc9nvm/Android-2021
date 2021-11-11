package com.base.android_2021.ui.main.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.android_2021.data.AppDataManager
import com.base.android_2021.data.networking.model.request.LoginRequest
import com.base.android_2021.utils.TrackingError
import com.base.android_2021.utils.validate.ValidateException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataManager: AppDataManager,
    private val trackingError: TrackingError
) : ViewModel() {
    private val _loginSuccess: MutableLiveData<String> = MutableLiveData()
    val loginSuccess: LiveData<String> get() = _loginSuccess

    fun doLogin(
        email: String,
        password: String
    ) {
        viewModelScope.launch(trackingError.coroutineExceptionHandler()) {
            val isValid = validate(email, password)
            dataManager.doLogin(isValid).data?.let {
                dataManager.doSaveToken(it.accessToken ?: "")
            }
        }
    }

    private fun validate(email: String, password: String): LoginRequest {
        return when {
            email.isEmpty() -> throw ValidateException("email empty")
            password.isEmpty() -> throw ValidateException("password empty")
            else -> LoginRequest(email, password)
        }
    }
}