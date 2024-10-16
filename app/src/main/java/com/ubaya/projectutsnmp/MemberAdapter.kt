package com.ubaya.projectutsnmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ActivityMemberDetailBinding

class MemberAdapter (private val members: List<MemberBank>) : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>(){
    class MemberViewHolder(val binding: ActivityMemberDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(member: MemberBank) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val binding = ActivityMemberDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val member = members[position]
        holder.bind(member)

        holder.binding.playerName.text = member.nama
        holder.binding.playerRole.text = member.role
        holder.binding.profileImage.setImageResource(member.gambar)

    }

    override fun getItemCount(): Int {
        return members.size
    }


}