package com.ubaya.projectutsnmp
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ItemTeamBinding

class TeamsAdapter(private val teams: List<String>) : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val teamName = teams[position]
        holder.binding.textTeamName.text = teamName
        // Handle item click if needed
    }

    override fun getItemCount(): Int = teams.size
}
