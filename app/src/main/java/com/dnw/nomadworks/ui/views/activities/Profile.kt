package com.dnw.nomadworks.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dnw.nomadworks.databinding.ActivityProfileBinding
import com.dnw.nomadworks.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private lateinit var auth: FirebaseAuth
    private var databaseReference : DatabaseReference?= null
    private var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // initialize
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        getUserProfile()
    }

    private fun getUserProfile(){
        /* TODO
        * get user profile(userDBRef.addValueEventListener(object: ValueEventListener{})
        * read profile data
        * logout (auth.signOut())
        * */
        val loggedInUser = auth.currentUser
        val userDBRef= databaseReference?.child(loggedInUser?.uid!!)
    }
}