package com.dnw.nomadworks.ui.views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dnw.nomadworks.databinding.FragmentAccountBinding
import com.dnw.nomadworks.ui.views.activities.Login
import com.google.firebase.auth.FirebaseAuth

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container,false)
        auth = FirebaseAuth.getInstance()

        binding.signOutLinearL.setOnClickListener {
            logout()
        }
        return binding.root
    }

    private fun logout(){
        auth.signOut()
        val intent = Intent(context, Login::class.java)
        startActivity(intent)
        Toast.makeText(context,"Successfully Logged Out", Toast.LENGTH_SHORT).show()
    }
}