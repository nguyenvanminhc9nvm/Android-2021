package com.base.android_2021.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.base.android_2021.utils.ProgressDialog
import com.base.android_2021.utils.TrackingError
import javax.inject.Inject

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), INavigatorActivity {

    @Inject
    lateinit var trackingErrorHelper: TrackingError

    private var _binding: ViewBinding? = null
    abstract val inflater: (LayoutInflater) -> VB
    private lateinit var progressDialog: ProgressDialog

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        progressDialog = ProgressDialog(this)
        trackingErrorHelper.coroutineExceptionHandler()
        setup()
    }

    abstract fun setup()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun showLoading() {
        if (!progressDialog.isShowing) {
            progressDialog.show()
        }
    }

    private fun hideLoading() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
}