package com.base.android_2021.ui.main

import androidx.lifecycle.ViewModel
import com.base.android_2021.data.AppDataManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataManager: AppDataManager
): ViewModel() {

}