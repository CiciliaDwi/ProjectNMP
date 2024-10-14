package com.ubaya.projectutsnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ActivityWhatWePlayBinding

class GameAdapter() : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    class GameViewHolder(val binding: ActivityWhatWePlayBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: GameBank) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.GameViewHolder {
        val binding = ActivityWhatWePlayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return com.ubaya.projectutsnmp.GameAdapter.GameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return GameData.game.size
    }

    override fun onBindViewHolder(holder: GameAdapter.GameViewHolder, position: Int) {
        val game = GameData.game[position]
        holder.bind(game)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ActivityWhatWePlayBinding::class.java)
            intent.putExtra("EVENT_NAME", game.judul)
            context.startActivity(intent)
        }
        holder.binding.imgGame.setImageResource(GameData.game[position].imageId)
        holder.binding.txtJudulGames.text = GameData.game[position].judul
        holder.binding.txtDescGames.text = GameData.game[position].desc
    }
}