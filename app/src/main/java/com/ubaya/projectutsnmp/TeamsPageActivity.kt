package com.ubaya.projectutsnmp

import TeamsAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectutsnmp.databinding.ActivityAchievementsDetailBinding
import com.ubaya.projectutsnmp.databinding.ActivityTeamsPageBinding

private lateinit var binding: ActivityTeamsPageBinding

class TeamsPageActivity : AppCompatActivity() {

    // List pencapaian (achievements)
    private val teams = listOf(
        "Team A",
        "Team B",
        "Team C",
        "Team D",
        "Team E"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the selected game name from Intent
        val gameName = intent.getStringExtra("GAME_NAME")

        // Choose the appropriate team list and image based on the game selected
        val teams = when (gameName) {
            "PUBG" -> listOf("PUBG Team 1", "PUBG Team 2", "PUBG Team 3")
            "Mobile Legends" -> listOf("ML Team 1", "ML Team 2", "ML Team 3")
            "Valorant" -> listOf("Valorant Team 1", "Valorant Team 2", "Valorant Team 3")
            else -> listOf("Unknown Team")
        }

        val bannerImage = when (gameName) {
            "PUBG" -> R.drawable.pubg1 // Replace with actual PUBG banner drawable
            "Mobile Legends" -> R.drawable.moba// Replace with actual Mobile Legends banner drawable
            "Valorant" -> R.drawable.valorant // You already have this one
            else -> R.drawable.bg2// A default banner in case of unknown
        }

        // Set the banner image
        binding.bannerImage.setImageResource(bannerImage)

        // Setup the RecyclerView with the appropriate teams
        binding.teamsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.teamsRecyclerView.adapter = TeamsAdapter(teams)
    }
}