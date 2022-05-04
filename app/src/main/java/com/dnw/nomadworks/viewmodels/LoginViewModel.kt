package com.dnw.nomadworks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dnw.nomadworks.models.LoginModel
import com.dnw.nomadworks.repository.LoginRepo

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = LoginRepo()
    val isAuthenticated : LiveData<Boolean>

    init {
        isAuthenticated = repo.isAuthenticated
    }

    fun login(user : LoginModel){
        repo.login(user)
    }
}