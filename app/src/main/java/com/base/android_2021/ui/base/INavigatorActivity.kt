package com.base.android_2021.ui.base

import android.os.Bundle

interface INavigatorActivity {
    fun navigateFragment(fragmentId: Int, bundle: Bundle)

    fun popBackStackFragment(fragmentId: Int)
}