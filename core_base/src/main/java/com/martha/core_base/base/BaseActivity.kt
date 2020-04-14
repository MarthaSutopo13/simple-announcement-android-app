package com.martha.core_base.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martha.core_base.R
import com.martha.core_base.util.PreferencesHelper

abstract class BaseActivity: AppCompatActivity(), BaseActivityView {

    lateinit var mContext: Context
    lateinit var preferenceHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(setLayout())
        initActivity()
        onInitializedView(savedInstanceState)
    }

    fun initActivity() {
        mContext = this
        preferenceHelper = PreferencesHelper(this)
    }

    abstract fun setLayout() : Int
    protected abstract fun onInitializedView(savedInstanceState: Bundle?)

    override fun getContext(): Context? {
        return mContext
    }

    override fun goToActivity(c: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        val i = Intent(this, c)
        if (bundle != null) {
            i.putExtras(bundle)
        }
        startActivity(i)
        overridePendingTransition(R.anim.to_up, R.anim.stay)
        if (isFinish) {
            finish()
        }
    }
}