    package com.ubaya.projectutsnmp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectutsnmp.databinding.ActivityAchievementsDetailBinding

class AchievementsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAchievementsDetailBinding
    private lateinit var achievementList: ListView
    private lateinit var spinnerTahun: Spinner
    private lateinit var adapter: ArrayAdapter<String>
    private var filteredAchievements = mutableListOf<String>() // Filtered list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil list achievement dari Intent
        val achievements = intent.getParcelableArrayListExtra<AchievementBank>("achievement")

        // Mengambil nama game dari Intent
        val namaGame = intent.getStringExtra("nama")

        // Set the title or any UI component with the game name
        if (namaGame != null) {
            title = "Achievements for $namaGame"
        }

        // Jika data achievement tidak null, konversi AchievementBank ke string untuk ditampilkan di ListView
        if (achievements != null) {
            filteredAchievements = achievements.map { "${it.nama} (${it.tahun})" }.toMutableList()
        }

        // Inisialisasi ListView dan Adapter
        achievementList = findViewById(R.id.achievementList)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, filteredAchievements)
        achievementList.adapter = adapter

        // Inisialisasi Spinner untuk filter tahun
        spinnerTahun = findViewById(R.id.spinnerTahun)
        val years = arrayOf("All", "2024", "2023", "2022") // Daftar tahun sesuai dengan data
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTahun.adapter = yearAdapter

        // Listener untuk Spinner, digunakan untuk memfilter achievement berdasarkan tahun
        spinnerTahun.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedYear = parent.getItemAtPosition(position).toString()
                filterAchievementsByYear(selectedYear, achievements)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Tidak ada aksi yang dilakukan jika tidak ada item yang dipilih
            }
        }
    }

    // Fungsi untuk memfilter achievement berdasarkan tahun
    private fun filterAchievementsByYear(year: String, achievements: List<AchievementBank>?) {
        filteredAchievements.clear()

        if (year == "All") {
            // Jika tahun "All" dipilih, tampilkan semua achievements
            if (achievements != null) {
                filteredAchievements.addAll(achievements.map { "${it.nama} (${it.tahun})" })
            }
        } else {
            // Filter berdasarkan tahun
            val yearInt = year.toIntOrNull() ?: return
            if (achievements != null) {
                filteredAchievements.addAll(achievements.filter { it.tahun == yearInt }
                    .map { "${it.nama} (${it.tahun})" })
            }
        }

        // Beritahu adapter bahwa data telah berubah
        adapter.notifyDataSetChanged()
    }
}