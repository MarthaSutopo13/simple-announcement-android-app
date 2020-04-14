package com.martha.announcement.customview

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.martha.announcement.R
import com.martha.core_base.base.BaseActivity
import com.martha.core_base.base.BaseDialogFragmentView
import com.martha.core_base.base.BaseView
import com.martha.core_base.util.PreferencesHelper

open abstract class RoundedBottomSheetDialogFragment: BottomSheetDialogFragment(), BaseDialogFragmentView {

    lateinit var mContext: Context
    lateinit var preferenceHelper: PreferencesHelper
    private lateinit var rootView: View

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(setLayout(), container, false)
        onViewInitialized(savedInstanceState)
        mContext = activity!!
        preferenceHelper = PreferencesHelper(mContext)
        return rootView
    }

    override fun getContext(): Context? {
        return super.getContext()
    }

    protected abstract fun onViewInitialized(savedInstanceState: Bundle?)

    abstract fun setLayout() : Int

    override fun goToActivity(c: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        (activity as BaseActivity).goToActivity(c, bundle, isFinish)
    }
}