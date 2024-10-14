package com.ubaya.projectutsnmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}