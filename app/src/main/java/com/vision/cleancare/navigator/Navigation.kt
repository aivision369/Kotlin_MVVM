package com.vision.cleancare.navigator

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class Navigation {
    fun navigateTo(activity: Activity, aClass: Class<*>?) {
        val intent = Intent(activity, aClass)
        activity.startActivity(intent)
    }

    companion object {
        fun getInstance(): Navigation {
            return Navigation()
        }
    }
}