package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectutsnmp.databinding.ActivityScheduleDetailBinding
import com.ubaya.projectutsnmp.databinding.ActivitySchedulePageBinding
import com.ubaya.projectutsnmp.databinding.ActivityWhoWeAreBinding

private lateinit var binding: ActivitySchedulePageBinding

class SchedulePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_schedule_page)


        // Enable edge to edge
        enableEdgeToEdge()

        // Menggunakan binding untuk layout "main"
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.layout1.setOnClickListener {
            val intent = Intent(this, ScheduleDetailActivity::class.java)
            startActivity(intent)
        }

    }
}