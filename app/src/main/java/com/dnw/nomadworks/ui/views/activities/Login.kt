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
    import com.dnw.nomadworks.databinding.ActivityLoginBinding
    import com.dnw.nomadworks.models.LoginModel
    import com.dnw.nomadworks.viewmodels.LoginViewModel


    class Login : AppCompatActivity() {

        private lateinit var binding: ActivityLoginBinding
        private lateinit var viewModel : LoginViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)

             viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

             binding.loginBtn.setOnClickListener {
                Log.d("LoginBtn", "Login button clicked ")
                val email = binding.loginEmailET.text.toString()
                val pwd = binding.loginPwdET.text.toString()
                 binding.pbLoginLoading.visibility = View.VISIBLE

                 val user = LoginModel(email, pwd)

                if(isValid(email, pwd)){
                        viewModel.login(user)
                } else {
                    Toast.makeText(this,"Please enter valid credentials", Toast.LENGTH_LONG).show()
                    Log.d("Invalid", "Empty or Null")
                }
            }

            viewModel.isAuthenticated.observe(this) {
                val msg: String
                if (it == true) {
                    msg = "Login success"
                    binding.pbLoginLoading.visibility = View.GONE
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    msg = "Login failed, Please try again!!"
                }
                Toast.makeText(application, msg, Toast.LENGTH_LONG).show()
            }

            /**
             * color style to apply to substrings
             **/
            val regHereTxt = binding.registerHereTV.text
            val mTxt = SpannableString(regHereTxt)
            val mBlue = ForegroundColorSpan(Color.BLUE)
            mTxt.setSpan(mBlue,23,36,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            binding.registerHereTV.text = mTxt

            binding.registerHereTV.setOnClickListener {
                startActivity(Intent(this@Login, Register::class.java))
            }

        }

        /** check user credentials is not null or empty */
        private fun isValid(email : String, pwd:String): Boolean {
            if(email.isEmpty() || pwd.isEmpty()){
                return false
            }
            return true
        }
    }