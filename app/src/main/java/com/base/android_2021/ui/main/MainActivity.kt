package com.base.android_2021.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.base.android_2021.R
import com.base.android_2021.databinding.ActivityMainBinding
import com.base.android_2021.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController

    private val viewModel: MainViewModel by viewModels()

    override fun setup() {

        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun navigateFragment(fragmentId: Int, bundle: Bundle) {
        val navBuilder = NavOptions.Builder()
        navBuilder.setEnterAnim(android.R.anim.slide_in_left)
            .setExitAnim(android.R.anim.slide_out_right)
            .setPopEnterAnim(android.R.anim.slide_out_right)
            .setPopExitAnim(android.R.anim.slide_in_left)

        navController.navigate(fragmentId, bundle, navBuilder.build())
    }

    override fun popBackStackFragment(fragmentId: Int) {
        navController.popBackStack(fragmentId, false)
    }

    override val inflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

}