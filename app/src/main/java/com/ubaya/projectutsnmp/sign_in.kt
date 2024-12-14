package com.ubaya.projectutsnmp

import android.R
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectutsnmp.databinding.ActivitySignInBinding
import com.ubaya.projectutsnmp.databinding.ActivitySignUpBinding
import com.ubaya.projectutsnmp.databinding.ActivityWhatWePlayBinding
import org.json.JSONObject


private lateinit var binding: ActivitySignInBinding

class sign_in : AppCompatActivity() {
    var account : ArrayList<UserBank> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

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

        val q = Volley.newRequestQueue(this)
        val url = "https://ubaya.xyz/native/160422148/get_users.php"
        var stringRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> {
                Log.d("apiresult", it)
                val obj = JSONObject(it)
                if (obj.getString("result") == "success") {
                    val data = obj.getJSONArray("data")
//                    for (i in 0 until data.length()) {
//                        val plyObj = data.getJSONObject(i)
//                        val users = UserBank(
//                            plyObj.getInt("id"),
//                            plyObj.getString("username"),
//                            plyObj.getString("password"),
//                            plyObj.getString("img_url")
//                        )
//                        account.add(users)
//                    }
                    for (i in 0 until data.length()) {
                        val plyObj = data.getJSONObject(i)
                        val users = UserBank(
                            plyObj.getString("username"),
                            plyObj.getString("password")
                        )
                        account.add(users)
                    }
                }
                Log.d("cekisiarray", account.toString())
            },
            Response.ErrorListener {
                // Handle error here
                Log.e("apiresult", it.message.toString())
            }
        )
        q.add(stringRequest)

        // Set up the login button action
        binding.btnLogin.setOnClickListener {
            var username = binding.txtBoxUser.text.toString()
            var password = binding.txtBoxPass.text.toString()
            for (user in account){
                if(user.username == username && user.password == password){
                    val intent = Intent(this, ActivityWhatWePlayBinding::class.java)
                    startActivity(intent)
                    finish() // Close the sign-in activity
                }
            }
            Toast.makeText(this, "Data Tidak Ada", Toast.LENGTH_SHORT).show()
            // Example: Validate user credentials (replace this with your validation logic)
//            val username = binding.txtBoxusername.editText?.text.toString()
//            val password = binding.txtBoxpass.editText?.text.toString()
//
//            if (username.isNotEmpty() && password.isNotEmpty()) {
//                // If login is successful:
//                // Save login state in SharedPreferences
//                with(sharedPreferences.edit()) {
//                    putBoolean("isLoggedIn", true)
//                    apply()
//                }
//
//                // Redirect to What We Play activity
//                val intent = Intent(this, ActivityWhatWePlayBinding::class.java)
//                startActivity(intent)
//                finish() // Close the sign-in activity
//            } else {
//                // Handle empty fields or show an error message
//                binding.txtBoxusername.error = "Please enter a username"
//                binding.txtBoxpass.error = "Please enter a password"
//            }
        }

        binding.signUpButton.setOnClickListener {
            val intent = Intent(this, ActivitySignUpBinding::class.java)
            startActivity(intent)
        }
    }
}