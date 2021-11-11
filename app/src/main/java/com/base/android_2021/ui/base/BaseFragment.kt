package com.base.android_2021.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.base.android_2021.utils.ProgressDialog
import com.base.android_2021.utils.TrackingError
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    @Inject
    lateinit var trackingErrorHelper: TrackingError

    private lateinit var mINavigatorActivity: INavigatorActivity
    private var _binding: ViewBinding? = null
    abstract val inflaterBinding: (LayoutInflater, ViewGroup?, Boolean) -> VB
    private lateinit var progressDialog: ProgressDialog

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    lateinit var mActivity: BaseActivity<*>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigatorActivity) {
            mINavigatorActivity = context
            progressDialog = ProgressDialog(context)
            mActivity = context as BaseActivity<*>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflaterBinding.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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