package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ActivityMainBinding
import com.ubaya.projectutsnmp.databinding.ActivityEventListBinding
import com.ubaya.projectutsnmp.databinding.ActivityWhatWePlayBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGame.setOnClickListener {
            val intent = Intent(this, ListGame::class.java)
            startActivity(intent)
        }

        // Menggunakan binding untuk tombol "Who We Are"
        binding.btnTeam.setOnClickListener {
            val intent = Intent(this, WhoWeAreActivity::class.java)
            startActivity(intent)
        }

        // Menggunakan binding untuk tombol "Our Schedule"
        binding.btnSchedule.setOnClickListener {
            val intent = Intent(this, EventListActivity::class.java)
            startActivity(intent)
        }
        binding.imgProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }
}