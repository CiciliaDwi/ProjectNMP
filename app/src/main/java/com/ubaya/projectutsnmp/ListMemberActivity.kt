package com.ubaya.projectutsnmp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectutsnmp.databinding.ActivityListMemberBinding

private lateinit var binding: ActivityListMemberBinding

class ListMemberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

      val members: ArrayList<MemberBank>? = intent.getParcelableArrayListExtra("member")
        val gameIndex = intent.getIntExtra("game_index", 0)

        binding.headerImage.setImageResource(GameData.game[gameIndex].imageId)

        binding.recMember.layoutManager = LinearLayoutManager(this)
        binding.recMember.setHasFixedSize(true)
        binding.recMember.adapter = EventAdapter()

    }
//    override fun onResume() {
//        super.onResume()
//        binding.recMember.layoutManager = LinearLayoutManager(this)
//        binding.recMember.setHasFixedSize(true)
//        binding.recMember.adapter = EventAdapter()
//    }
}