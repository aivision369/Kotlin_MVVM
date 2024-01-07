package com.vision.cleancare.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(private val _context: Context) : ViewModel() {
    @JvmField
    var title = MutableLiveData<String>()
    @JvmField
    var version = MutableLiveData<String>()


    @JvmField
    var email = MutableLiveData<String>()
    @JvmField
    var password = MutableLiveData<String>()


    var validation = MutableLiveData<String>()
    var isEmailFocused = MutableLiveData<Boolean>()
    var isPasswordFocused = MutableLiveData<Boolean>()
    var directLogin = MutableLiveData<Boolean>()

   /* private val loginRequest: LoginRequest = LoginRequest()
    var loginMutableLiveData = MutableLiveData<LoginRequest>()
    fun onLoginClicked() {
        loginRequest.loginName = email.value
        loginRequest.password = password.value
        if (loginRequest.isEmpty) {
            with(validation) { setValue("enter email ID") }
            return
        } else if (!loginRequest.isValidPassword) {
            validation.value = "enter valid password"
            return
        }
        loginMutableLiveData.value = loginRequest

    }*/

    fun validation(): LiveData<String> {
        return validation
    }

    fun setIsEmailFocused(value: Boolean) {
        isEmailFocused.value = value
    }

    fun setIsPasswordFocused(value: Boolean) {
        isPasswordFocused.value = value
    }


    fun onDirectLogin() {
        directLogin.value = true
    }

    fun directLogin(): LiveData<Boolean> {
        return directLogin
    }

    init {
        title.value = ""
        version.value = ""
    }
}