package com.base.android_2021.ui.main

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
class MainViewModel @Inject constructor(
    private val dataManager: AppDataManager,
    private val trackingErrorHelper: TrackingError
) : ViewModel() {

}
