package com.ubaya.projectutsnmp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ActivityScheduleDetailBinding

private lateinit var binding: ActivityScheduleDetailBinding

class ScheduleDetailActivity : AppCompatActivity() {
    class EventViewHolder(val binding: ActivityScheduleDetailBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: EventBank) {
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding
        binding = ActivityScheduleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val eventName = intent.getStringExtra("EVENT_NAME")
        val eventTgl = intent.getStringExtra("EVENT_TGL")
        val eventTim = intent.getStringExtra("EVENT_TIM")
        val eventImage = intent.getIntExtra("EVENT_IMAGE", 0)
        val eventDesc = intent.getStringExtra("EVENT_DESC")

        // Menampilkan data di layout, sesuaikan dengan ID view yang ada di activity_schedule_detail.xml
        binding.txtJudul.text = eventName
        binding.txtTgl.text = eventTgl
        binding.txtTeam.text = eventTim
        binding.imageView2.setImageResource(eventImage)
        binding.eventDesc.text = eventDesc

        // Menggunakan binding untuk tombol "Notify Me"
        binding.notifyButton.setOnClickListener {
            // Tampilkan toast message menggunakan binding
            Toast.makeText(this, "Notification created.", Toast.LENGTH_SHORT).show()

        }

        binding.imageProfile2.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}