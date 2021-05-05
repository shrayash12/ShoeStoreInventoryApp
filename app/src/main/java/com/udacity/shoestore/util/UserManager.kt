package com.udacity.shoestore.util

import android.content.Context

object UserManager {

    fun saveUserLogin(context: Context, email: String, password: String) {
        val sharePref =
            context.getSharedPreferences(Constants.KEY_MY_SHARE_PREF, Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        editor.putString(Constants.KEY_MY_SHARE_EMAIL, email)
        editor.putString(Constants.KEY_MY_SHARE_PASSWORD, password)
        editor.apply()
    }

    fun getUserLogin(context: Context): Pair<String, String> {
        val sharePref =
            context.getSharedPreferences(Constants.KEY_MY_SHARE_PREF, Context.MODE_PRIVATE)
        val email = sharePref.getString(Constants.KEY_MY_SHARE_EMAIL, "") ?: ""
        val password = sharePref.getString(Constants.KEY_MY_SHARE_PASSWORD, "") ?: ""
        return Pair(email, password)
    }

    fun logOut(context: Context) {
        val sharePref =
            context.getSharedPreferences(Constants.KEY_MY_SHARE_PREF, Context.MODE_PRIVATE)
        sharePref
            .edit()
            .clear()
            .apply()

    }
}