package com.martha.core_base.base

import android.content.Context

interface BaseActivityView: BaseView {
    fun getContext(): Context?
}