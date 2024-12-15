package com.ubaya.projectutsnmp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.ProposalAdapter.ProposalViewHolder
import com.ubaya.projectutsnmp.databinding.ActivityProposalCardBinding

class NewProposalAdapter (var proposal:ArrayList<ProposalBank>): RecyclerView.Adapter<NewProposalAdapter.NewProposalViewHolder>() {
    class NewProposalViewHolder(val binding: ActivityProposalCardBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewProposalViewHolder {
        val binding = ActivityProposalCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return NewProposalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewProposalViewHolder, position: Int) {
        Log.d("RecyclerView", "Binding item at position $position: ${proposal[position].game}")
        holder.binding.txtProposal.text = proposal[position].game
        holder.binding.txtStatus.text = proposal[position].status
    }

    override fun getItemCount(): Int {
        return proposal.size;

    }
}