package com.martha.core_base.base

import android.os.Bundle

interface BaseView {
    fun goToActivity(c: Class<*>, bundle: Bundle?, isFinish: Boolean)
}