package com.ubaya.projectutsnmp

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
    private lateinit var likeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhoWeAreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_who_we_are)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        likeCount = 0
        likeText = findViewById(R.id.txtLike)
        val likeButton: Button = findViewById(R.id.btnLike)

        likeButton.setOnClickListener {
            likeCount++
            likeText.text = likeCount.toString()
            Log.d("WhoWeAreActivity", "Button clicked, current like count: $likeCount")

        }
    }
}