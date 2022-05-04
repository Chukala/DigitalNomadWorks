package com.dnw.nomadworks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dnw.nomadworks.repository.RegisterRepo

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = RegisterRepo()
    val isRegistered : LiveData<Boolean>

    init {
        isRegistered = repo.isRegistered
    }

    fun register(fName:String, lName:String, email:String, pwd:String){
        repo.register(fName, lName, email, pwd)
    }
}