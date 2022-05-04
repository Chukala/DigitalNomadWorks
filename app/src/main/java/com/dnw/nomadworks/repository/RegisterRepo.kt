package com.dnw.nomadworks.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dnw.nomadworks.models.RegisterModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterRepo {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var db: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var dbRef:DatabaseReference = db.reference.child("profile")
    val isRegistered = MutableLiveData<Boolean>()


    fun register( fName: String, lName: String, email: String, pwd: String) {
        val user = RegisterModel(fName,lName, email, pwd)
        auth.createUserWithEmailAndPassword(user.email, user.pwd)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("Register", "Register success")
                    val currentUser = auth.currentUser
                    val userDB = dbRef.child(currentUser?.uid!!)
                    userDB?.child("firstName")?.setValue(fName)
                    userDB?.child("lastName")?.setValue(lName)

                    isRegistered.value = it.isSuccessful

                } else {
                    Log.d("Register", "Registration failed")
                    isRegistered.value = false
                }
            }
    }


}