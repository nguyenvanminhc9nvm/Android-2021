package com.base.android_2021.ui.main.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.android_2021.R
import com.base.android_2021.databinding.ListFragmentBinding
import com.base.android_2021.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<ListFragmentBinding>() {
    override val inflaterBinding: (LayoutInflater, ViewGroup?, Boolean) -> ListFragmentBinding
        = ListFragmentBinding::inflate

    override fun setup() {

    }


}