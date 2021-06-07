package com.udacity.shoestore.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogInViewModel : ViewModel() {
    var email: String = ""
    var password: String = ""

    private val user = MutableLiveData<User>()

    val userLiveData : LiveData<User> = user

    fun setUser(user: User){
        this.user.value = user
    }

}