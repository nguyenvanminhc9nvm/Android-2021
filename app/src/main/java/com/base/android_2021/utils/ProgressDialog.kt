package com.base.android_2021.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.base.android_2021.R

class ProgressDialog constructor(context: Context) : Dialog(context) {
    init {
        setCancelable(false)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_progress)
        val window = window
        if (window != null) {
            getWindow()!!.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }
}