package com.ubaya.projectutsnmp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectutsnmp.databinding.ActivityApplyNewTeamBinding
import com.ubaya.projectutsnmp.databinding.ActivityNavigationDrawerBinding
import com.ubaya.projectutsnmp.databinding.ActivityProfileBinding



class NavigationDrawerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE)

        // Logika tombol logout
        binding.btnLogout.setOnClickListener {
            // Hapus sesi pengguna
            with(sharedPreferences.edit()) {
                clear()
                apply()
            }

            // Redirect ke halaman SignIn
            val intent = Intent(this, sign_in::class.java)
            startActivity(intent)
            finish() // Tutup MainActivity
        }
        binding.btnApplyTeam.setOnClickListener{
            val intent = Intent(this, ApplyNewTeamActivity::class.java)
            startActivity(intent)
        }
    }
}