package com.ubaya.projectutsnmp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.ubaya.kpe_uas_w9.MyAdapter
import com.ubaya.projectutsnmp.databinding.ActivityMainBinding
import com.ubaya.projectutsnmp.databinding.ActivityEventListBinding
import com.ubaya.projectutsnmp.databinding.ActivityWhatWePlayBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val fragments: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val sharedPreferences: SharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE)
//
//        // Logika tombol logout
//        binding.btnLogout.setOnClickListener {
//            // Hapus sesi pengguna
//            with(sharedPreferences.edit()) {
//                clear()
//                apply()
//            }
//
//            // Redirect ke halaman SignIn
//            val intent = Intent(this, sign_in::class.java)
//            startActivity(intent)
//            finish() // Tutup MainActivity
//        }

        fragments.add(WhatWePlayFragment())
        fragments.add(WhoWeAreFragment())
        fragments.add(OurScheduleFragment())

        binding.viewPager.adapter = MyAdapter(this, fragments)

//        binding.btnGame.setOnClickListener {
//            val intent = Intent(this, ListGame::class.java)
//            startActivity(intent)
//        }
//
//        // Menggunakan binding untuk tombol "Who We Are"
//        binding.btnTeam.setOnClickListener {
//            val intent = Intent(this, WhoWeAreActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Menggunakan binding untuk tombol "Our Schedule"
//        binding.btnSchedule.setOnClickListener {
//            val intent = Intent(this, EventListActivity::class.java)
//            startActivity(intent)
//        }

        binding.imgProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.imgNavigationDrawer.setOnClickListener {
            val intent = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(intent)
        }

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNav.selectedItemId = binding.bottomNav.menu.getItem(position).itemId
            }
        })

        //when we click the navbottom button, let the viewpager sync
        binding.bottomNav.setOnItemSelectedListener {
            binding.viewPager.currentItem = when(it.itemId) {
                R.id.itemWhatWePlay -> 0
                R.id.itemWhoWeAre -> 1
                R.id.itemOurSchedule -> 2
                else -> 0 // default to home
            }
            true

        }


    }
}