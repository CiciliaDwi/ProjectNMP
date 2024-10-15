package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
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

    }
    override fun onResume() {
        super.onResume()
        binding.recGame.layoutManager = LinearLayoutManager(this)
        binding.recGame.setHasFixedSize(true)
        binding.recGame.adapter = GameAdapter()
    }

}