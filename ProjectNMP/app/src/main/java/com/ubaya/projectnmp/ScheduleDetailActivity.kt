package com.ubaya.projectutsnmp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectutsnmp.databinding.ActivityScheduleDetailBinding

private lateinit var binding: ActivityScheduleDetailBinding

class ScheduleDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding
        binding = ActivityScheduleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Menggunakan binding untuk tombol "Notify Me"
        binding.notifyButton.setOnClickListener {
            // Tampilkan toast message menggunakan binding
            Toast.makeText(this, "Notification created.", Toast.LENGTH_SHORT).show()
        }
    }
}
