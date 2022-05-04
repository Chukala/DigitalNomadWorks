package com.dnw.nomadworks.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dnw.nomadworks.models.LoginModel
import com.google.firebase.auth.FirebaseAuth

class LoginRepo {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
     val isAuthenticated = MutableLiveData<Boolean>()


    fun login(user: LoginModel) {
        auth.signInWithEmailAndPassword(user.email, user.pwd).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("Login","Login success")
                isAuthenticated.value = it.isSuccessful
            } else {
                Log.d("Login","Login failed")
                isAuthenticated.value = false
            }
        }
    }


}