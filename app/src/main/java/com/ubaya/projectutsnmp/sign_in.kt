package com.ubaya.projectutsnmp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectutsnmp.databinding.ActivityEventListBinding
import com.ubaya.projectutsnmp.databinding.ActivitySignInBinding
import com.ubaya.projectutsnmp.databinding.ActivityWhatWePlayBinding
import com.ubaya.projectutsnmp.databinding.ActivitySignUpBinding

private lateinit var binding: ActivitySignInBinding

class sign_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        val url = "http://10.0.2.2/music/login.php"

        // Initialize SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        // Check if the user has logged in before
        if (isLoggedIn) {
            // Redirect to What We Play activity
            val intent = Intent(this, ActivityWhatWePlayBinding::class.java)
            startActivity(intent)
            finish() // Close the sign-in activity
        }

        // Set up the login button action
        binding.btnLogin.setOnClickListener {
            // Example: Validate user credentials (replace this with your validation logic)
            val username = binding.txtBoxUsername.editText?.text.toString()
            val password = binding.txtBoxpassword.editText?.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // If login is successful:
                // Save login state in SharedPreferences
                with(sharedPreferences.edit()) {
                    putBoolean("isLoggedIn", true)
                    apply()
                }

                // Redirect to What We Play activity
                val intent = Intent(this, ActivityWhatWePlayBinding::class.java)
                startActivity(intent)
                finish() // Close the sign-in activity
            } else {
                // Handle empty fields or show an error message
                binding.txtBoxUsername.error = "Please enter a username"
                binding.txtBoxpassword.error = "Please enter a password"
            }
        }

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, ActivitySignUpBinding::class.java)
            startActivity(intent)
        }

//        // Set up the sign-up button to navigate to the sign-up activity
//        binding.btnSignUp.setOnClickListener {
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
//        }

    }
}