package com.ubaya.projectutsnmp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ActivityEventListBinding

private lateinit var binding: ActivityEventListBinding

class EventListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recSchedule.layoutManager = LinearLayoutManager(this)
        binding.recSchedule.setHasFixedSize(true)
        binding.recSchedule.adapter = EventAdapter()
    }
    override fun onResume() {
        super.onResume()
        binding.recSchedule.layoutManager = LinearLayoutManager(this)
        binding.recSchedule.setHasFixedSize(true)
        binding.recSchedule.adapter = EventAdapter()
    }



}