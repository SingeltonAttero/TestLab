package com.yakow.weber.myapplication.model.data.storage.prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Inject

/**
 * Created on 05.02.19
 * @author YWeber */

class AppPrefs @Inject constructor(private val context: Context) :
    PrefsProvider {

    companion object {
        private const val FIRST_LAUNCH_DATE = "first launch date"
    }

    private inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {
        edit().apply { block() }.apply()
    }

    private val sharedPrefs
            by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

    override var firstLaunchDate: String
        get() = sharedPrefs.getString(FIRST_LAUNCH_DATE, "") ?: ""
        set(value) {
            sharedPrefs.edit { putString(FIRST_LAUNCH_DATE, value) }
        }
}