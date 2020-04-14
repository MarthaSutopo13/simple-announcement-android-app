package com.martha.core_base.util

import android.content.Context
import android.preference.PreferenceManager

class PreferencesHelper(val context: Context) {
    companion object {
        private const val FILTER = "data.source.prefs.FILTER"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var filter = preferences.getString(FILTER, "")
    set(value) = preferences.edit().putString(FILTER,value).apply()
}