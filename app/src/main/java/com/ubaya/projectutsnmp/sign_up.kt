package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectutsnmp.databinding.ActivitySignUpBinding
import org.json.JSONObject

class sign_up : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            RegisUser()
        }
    }

    private fun RegisUser(){
        val firstname = binding.firstNameTextInputLayout.editText?.text.toString()
        val lastName = binding.lastNameTextInputLayout.editText?.text.toString()
        val username = binding.usernameTextInputLayout.editText?.text.toString()
        val password = binding.passwordTextInputLayout.editText?.text.toString()

        val q = Volley.newRequestQueue(this)
        val url = "https://ubaya.xyz/native/160422148/register.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                val obj = JSONObject(response)
                if (obj.getString("status") == "success") {
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, sign_in::class.java)
                    finish()
                } else {
                    // Registration failed, display an error message
                    Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                // Handle errors or exceptions here
                Log.d("RegisterError", error.printStackTrace().toString())
                Toast.makeText(this, "Error registering user", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["firstname"] = firstname
                params["lastname"] = lastName
                params["username"] = username
                params["password"] = password
                params["profile"] = "member"
                return params
            }
        }

        q.add(stringRequest)
    }
}