package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectutsnmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan binding untuk tombol "Who We Are"
        binding.btnTeam.setOnClickListener {
            val intent = Intent(this, WhoWeAreActivity::class.java)
            startActivity(intent)
        }

        // Menggunakan binding untuk tombol "Our Schedule"
        binding.btnSchedule.setOnClickListener {
            val intent = Intent(this, SchedulePageActivity::class.java)
            startActivity(intent)
        }
    }
}
