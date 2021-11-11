package com.base.android_2021.ui.main.login

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.base.android_2021.databinding.LoginFragmentBinding
import com.base.android_2021.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginFragmentBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override val inflaterBinding: (LayoutInflater, ViewGroup?, Boolean) -> LoginFragmentBinding
        = LoginFragmentBinding::inflate

    override fun setup() {
        viewModel.loginSuccess.observe(this) {
            Toast.makeText(mActivity, it, Toast.LENGTH_SHORT).show()
        }
        binding.btnLogin.setOnClickListener { 
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            viewModel.doLogin(email, password)
        }
    }
}