package com.owino.mcarretal

import android.content.Context

object Preferences {
    var DEFAULT_PREFS_FILE_NAME = "org.mcar_app.prefs"
    private const val USER_EMAIL_PREF = "email_pref"
    private const val USER_PASSWORD_PREF = "password_pref"
    fun setUserPasswordPref(context: Context, password: String) {
        setStringPref(context, USER_PASSWORD_PREF, password)
    }

    fun getUserPasswordPref(context: Context): String? {
        return getStringPrefs(context, USER_PASSWORD_PREF, "")
    }

    fun setUserEmailPref(context: Context, email: String) {
        setStringPref(context, USER_EMAIL_PREF, email)
    }

    fun getUserEmailPref(context: Context): String? {
        return getStringPrefs(context, USER_EMAIL_PREF, "")
    }

    private fun getBooleanPrefs(context: Context, prefName: String, defValue: Boolean): Boolean {
        return context.getSharedPreferences(DEFAULT_PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .getBoolean(prefName, defValue)
    }

    private fun setBooleanPrefs(context: Context, prefName: String, value: Boolean) {
        context.getSharedPreferences(DEFAULT_PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(prefName, value)
            .apply()
    }

    private fun setIntPrefs(context: Context, key: String, value: Int) {
        context.getSharedPreferences(DEFAULT_PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .edit()
            .putInt(key, value)
            .apply()
    }

    private fun getIntPref(context: Context, prefName: String, defaultVal: Int): Int {
        return context.getSharedPreferences(DEFAULT_PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .getInt(prefName, defaultVal)
    }

    private fun setStringPref(context: Context, prefName: String, value: String) {
        context.getSharedPreferences(DEFAULT_PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(prefName, value)
            .apply()
    }

    private fun getStringPrefs(context: Context, prefName: String, defaultVal: String?): String? {
        return context.getSharedPreferences(DEFAULT_PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .getString(prefName, defaultVal)
    }
}