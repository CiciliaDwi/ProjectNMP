package com.ubaya.projectutsnmp

import TeamsAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectutsnmp.databinding.ActivityTeamsPageBinding

private lateinit var binding: ActivityTeamsPageBinding

class TeamsPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameIndex = intent.getIntExtra("game_index", -1)

//        // Mengecek apakah game_index berhasil diterima
//        Log.d("TeamsPageActivity", "gameIndex: $gameIndex")
//
//        // Jika gameIndex tidak ditemukan (-1), tampilkan pesan kesalahan
//        if (gameIndex == -1) {
//            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
//            finish() // Tutup aktivitas jika data tidak valid
//            return
//        }

        // Melanjutkan proses jika gameIndex valid
        val selectedGame = GameData.game[gameIndex].judul
        binding.bannerImage.setImageResource(GameData.game[gameIndex].imageId)

        val filteredTeams = GameData.game.find { it.judul == selectedGame }
            ?.team
            ?.distinctBy { it.nama }



        if (filteredTeams != null) {
            // Setup RecyclerView dengan list tim dari objek TeamBank
            binding.teamsRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.teamsRecyclerView.adapter = TeamsAdapter(filteredTeams) { selectedTeam ->
                // Action ketika tim dipilih
                val intent = Intent(this, ListMemberActivity::class.java)
                intent.putParcelableArrayListExtra("member", ArrayList(selectedTeam.member))
                startActivity(intent)
            }
        }
    }
}
