package com.ubaya.projectutsnmp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectutsnmp.databinding.ActivityApplyNewTeamBinding
import org.json.JSONObject
import org.json.JSONArray

class ApplyNewTeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApplyNewTeamBinding
    private val gameList = mutableListOf<String>()
    private val teamList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplyNewTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Load data for Spinners
        loadSpinnerData()

        binding.buttonApply.setOnClickListener {
            val game = binding.spinnerGame.selectedItem?.toString()
            val team = binding.spinnerTeam.selectedItem?.toString()
            val description = binding.editTextDescription.text.toString()

            // Validasi input
            if (game.isNullOrEmpty() || team.isNullOrEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Kirim data ke server
            sendApplication(game, team, description)
        }
    }

    private fun loadSpinnerData() {
        val url = "https://ubaya.xyz/native/160422148/applyTeam.php" // URL PHP untuk mendapatkan data

        val q = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                try {
                    Log.d("apiresult", response)
                    val obj = JSONObject(response)

                    // Reset list sebelum menambahkan data baru
                    gameList.clear()
                    teamList.clear()

                    if (obj.getString("status") == "OK") {
                        val data = obj.getJSONArray("data")

                        // Debug: Cetak jumlah data
                        Log.d("apiresult", "Jumlah data: ${data.length()}")

                        for (i in 0 until data.length()) {
                            val item = data.getJSONObject(i)

                            // Debug: Cetak setiap item
                            Log.d("apiresult", "Item ke-$i: ${item.toString()}")

                            // Sesuaikan dengan struktur JSON yang sebenarnya
                            // Ganti "type" dan "name" sesuai dengan key di JSON
                            val teamName = item.optString("team_name", "")
                            val gameName = item.optString("game_name", "")

                            if (teamName.isNotEmpty()) teamList.add(teamName)
                            if (gameName.isNotEmpty()) gameList.add(gameName)
                        }

                        // Pastikan setup spinner dilakukan di UI thread
                        runOnUiThread {
                            setupSpinners()
                        }
                    } else {
                        Toast.makeText(this, obj.getString("message"), Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Log.e("apiresult", "Error parsing JSON: ${e.message}")
                    e.printStackTrace()
                }
            },
            { error ->
                Log.e("apiresult", "Volley Error: ${error.message}")
                Toast.makeText(this, "Failed to load data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        // Set retry policy untuk mengatasi timeout
        stringRequest.setShouldCache(false)
        q.add(stringRequest)
    }

    private fun setupSpinners() {
        // Debug: Cetak isi list
        Log.d("apiresult", "Game List: $gameList")
        Log.d("apiresult", "Team List: $teamList")

        // Pastikan list tidak kosong sebelum setup
        if (gameList.isNotEmpty()) {
            val gameAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gameList)
            gameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerGame.adapter = gameAdapter
        }

        if (teamList.isNotEmpty()) {
            val teamAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teamList)
            teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTeam.adapter = teamAdapter
        }
    }


    private fun sendApplication(member: String, team: String, description: String) {
        val url = "https://ubaya.xyz/native/160422148/join_proposal.php" // URL PHP untuk submit

        val q = Volley.newRequestQueue(this)
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)
                if (obj.getString("status") == "success") {
                    Toast.makeText(this, "Application submitted successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, obj.getString("message"), Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Log.e("apiresult", error.message.toString())
                Toast.makeText(this, "Failed to submit application.", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["team"] = binding.spinnerTeam.selectedItem.toString()
                params["member"] = binding.spinnerGame.selectedItem.toString()
                params["description"] = description
                return params
            }
        }
        q.add(stringRequest)
    }

}
