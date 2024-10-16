package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectutsnmp.databinding.ActivityListGameBinding

private lateinit var binding: ActivityListGameBinding

class ListGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recGame.layoutManager = LinearLayoutManager(this)
        binding.recGame.setHasFixedSize(true)
        binding.recGame.adapter = GameAdapter()

        binding.imageProfiles.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d("ListGame", "Binding RecyclerView with GameAdapter")
        binding.recGame.layoutManager = LinearLayoutManager(this)
        binding.recGame.setHasFixedSize(true)
        binding.recGame.adapter = GameAdapter()
    }
}