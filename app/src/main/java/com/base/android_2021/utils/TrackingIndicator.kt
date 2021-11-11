package com.base.android_2021.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Job
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class TrackingIndicator @Inject constructor(
    @ApplicationContext
    private val applicationContext: Context
) {
    fun trackingIndicator() {
        val progressDialog = ProgressDialog(applicationContext)

    }
}