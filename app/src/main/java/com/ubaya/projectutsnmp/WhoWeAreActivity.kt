package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectutsnmp.databinding.ActivityWhoWeAreBinding

private lateinit var binding: ActivityWhoWeAreBinding

class WhoWeAreActivity : AppCompatActivity() {

    private var likeCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhoWeAreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        likeCount = 0
        binding.btnLike.setOnClickListener {
            binding.btnLike.text = (likeCount++).toString()
        }

        binding.imageView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}