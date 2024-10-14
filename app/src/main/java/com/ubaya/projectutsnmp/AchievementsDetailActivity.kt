package com.ubaya.projectutsnmp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectutsnmp.databinding.ActivityAchievementsDetailBinding

private lateinit var binding: ActivityAchievementsDetailBinding

class AchievementsDetailActivity : AppCompatActivity() {

    // List pencapaian (achievements)
    private val achievements = listOf(
        "Champions of the Regional Valorant Showdown (2023) - Team A",
        "Best Defensive Team Award (2024) - Team A",
        "MVP of the Season (2023) - Team B",
        "Flawless Victory at the Spring Valorant Cup (2022) - Team A",
        "Top 4 Finish in the International Valorant Championship (2023) - Team C"
    )

    // List yang akan ditampilkan setelah difilter
    private lateinit var filteredAchievements: MutableList<String>
    private lateinit var achievementList: ListView
    private lateinit var spinnerTahun: Spinner
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Atur padding untuk edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi Spinner dan ListView
        spinnerTahun = findViewById(R.id.spinnerTahun)
        achievementList = findViewById(R.id.achievementList)

        // Inisialisasi daftar pencapaian yang difilter
        filteredAchievements = achievements.toMutableList()

        // Inisialisasi Adapter untuk ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, filteredAchievements)
        achievementList.adapter = adapter

        // Daftar tahun untuk Spinner
        val years = arrayOf("All", "2024", "2023", "2022")
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTahun.adapter = yearAdapter

        // Listener untuk Spinner ketika item dipilih
        spinnerTahun.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedYear = parent.getItemAtPosition(position).toString()
                filterAchievementsByYear(selectedYear)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Tidak ada yang dipilih, lakukan apa-apa
            }
        }
    }

    // Fungsi untuk memfilter pencapaian berdasarkan tahun
    private fun filterAchievementsByYear(year: String) {
        filteredAchievements.clear()

        if (year == "All") {
            // Tampilkan semua pencapaian jika "All" dipilih
            filteredAchievements.addAll(achievements)
        } else {
            // Filter pencapaian berdasarkan tahun
            achievements.forEach { achievement ->
                if (achievement.contains(year)) {
                    filteredAchievements.add(achievement)
                }
            }
        }

        // Beritahu adapter bahwa data telah berubah
        adapter.notifyDataSetChanged()
    }
}
