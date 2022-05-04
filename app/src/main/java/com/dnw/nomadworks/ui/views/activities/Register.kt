package com.dnw.nomadworks.ui.views.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dnw.nomadworks.databinding.ActivityRegisterBinding
import com.dnw.nomadworks.models.RegisterModel
import com.dnw.nomadworks.viewmodels.RegisterViewModel

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        binding.registerBtn.setOnClickListener {
            Log.d("RegisterBtn", "Register button clicked ")
            val fName = binding.firstNameET.text.toString()
            val lName = binding.lastNameET.text.toString()
            val email = binding.registerEmailET.text.toString()
            val pwd = binding.registerPwdET.text.toString()
            binding.pbLoading.visibility = View.VISIBLE

            val user = RegisterModel(fName, lName, email, pwd)


            if (isValid(fName, lName, email, pwd)) {

                viewModel.register(user.fName, user.lName, user.email, user.pwd)
            } else {
                Toast.makeText(this, "Please fill the data", Toast.LENGTH_LONG).show()
                Log.d("Fill the data", "Empty or Null")

            }
        }

        viewModel.isRegistered.observe(this) {
            val msg: String
            if (it == true) {
                binding.pbLoading.visibility = View.GONE
                msg = "Registered Successfully.Please login..."
                val intent = Intent(this@Register, Login::class.java)
                startActivity(intent)
                finish()

            } else {
                msg = "Registration failed, Please try again!!"
            }
            Toast.makeText(application, msg, Toast.LENGTH_LONG).show()
        }

        /**
         * Color style to apply to substrings
         **/
        val loginHereTxt = binding.loginHereTV.text
        val mTxt = SpannableString(loginHereTxt)
        val mBlue = ForegroundColorSpan(Color.BLUE)
        mTxt.setSpan(mBlue,25,35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.loginHereTV.text = mTxt

        binding.loginHereTV.setOnClickListener {
            startActivity(Intent(this@Register, Login::class.java))
        }

    }


    /** check user credentials is not null or empty */
    private fun isValid(fName: String, lName: String, email: String, pwd: String): Boolean {
        if (fName.isNullOrEmpty() || lName.isNullOrEmpty() || email.isNullOrEmpty() || pwd.isNullOrEmpty()) {
            return false
        }
        return true
    }

}



