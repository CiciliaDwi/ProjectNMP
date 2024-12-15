package com.ubaya.projectutsnmp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.ubaya.projectutsnmp.databinding.ActivityNavigationDrawerBinding
import com.ubaya.projectutsnmp.databinding.ActivityProposalListBinding
import org.json.JSONObject

class ProposalListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProposalListBinding
    var proposals:ArrayList<ProposalBank> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProposalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun updateList() {
            val lm = LinearLayoutManager(this)
            with(binding.recProposalList) {
                layoutManager = lm
                setHasFixedSize(true)
                adapter = NewProposalAdapter(proposals)
            }
        }
        val q = Volley.newRequestQueue(this)
        val url = "https://ubaya.xyz/native/160422150/proposal.php"
        var stringRequest = StringRequest(
            Request.Method.POST, url,
            {
                Log.d("apiresult", it)
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    for(i in 0 until data.length()) {
                        val playObj = data.getJSONObject(i)
                        val playlist = ProposalBank(
                            playObj.getInt("idjoin_proposal"),
                            playObj.getString("name"),
                            playObj.getString("status")
                        )
                        proposals.add(playlist)
                    }

                }
                updateList()
                Log.d("cekisiarray", proposals.toString())
            },
            {
                Log.e("apiresult", it.message.toString())
            }
        )
        q.add(stringRequest)
    }
}