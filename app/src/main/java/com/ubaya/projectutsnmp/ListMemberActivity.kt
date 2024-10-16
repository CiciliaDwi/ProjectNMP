package com.ubaya.projectutsnmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ActivityListMemberBinding

private lateinit var binding: ActivityListMemberBinding

class ListMemberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_member)

        // Get the list of members from the intent
        val members: ArrayList<MemberBank>? = intent.getParcelableArrayListExtra("member")

        if (members != null) {
            // Setup RecyclerView with members
            val recyclerView = findViewById<RecyclerView>(R.id.recMember)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = MemberAdapter(members)
        }

    }
}