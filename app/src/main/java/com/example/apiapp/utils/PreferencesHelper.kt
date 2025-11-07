package com.example.apiapp.utils // Make sure this package name matches yours

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class PreferencesHelper(context: Context) {

    private companion object {
        const val TAG = "PreferencesHelper"
        const val PREFS_NAME = "app_settings_prefs"
        const val KEY_DARK_MODE = "dark_mode_enabled"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    /**
     * Saves the user's Dark Mode preference.
     */
    fun setDarkModeEnabled(isEnabled: Boolean) {
        Log.d(TAG, "Saving Dark Mode preference: $isEnabled")
        with(sharedPreferences.edit()) {
            putBoolean(KEY_DARK_MODE, isEnabled)
            apply()
        }
    }

    /**
     * Retrieves the user's Dark Mode preference.
     * Defaults to 'false' (system default or light mode).
     */
    fun isDarkModeEnabled(): Boolean {
        val isEnabled = sharedPreferences.getBoolean(KEY_DARK_MODE, false)
        Log.d(TAG, "Loading Dark Mode preference: $isEnabled")
        return isEnabled
    }
}