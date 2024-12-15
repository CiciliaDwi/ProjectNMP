package com.ubaya.projectutsnmp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.EventAdapter.EventViewHolder
import com.ubaya.projectutsnmp.databinding.ActivityProposalCardBinding
import com.ubaya.projectutsnmp.databinding.ActivityProposalListBinding
import com.ubaya.projectutsnmp.databinding.ActivityWhatWePlayBinding
import com.ubaya.projectutsnmp.databinding.SchedulePageeBinding

class ProposalAdapter (var proposal:ArrayList<ProposalBank>): RecyclerView.Adapter<ProposalAdapter.ProposalViewHolder>() {
    class ProposalViewHolder(val binding: ActivityProposalCardBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProposalViewHolder {
        val binding = ActivityProposalCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return ProposalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProposalViewHolder, position: Int) {
        Log.d("RecyclerView", "Binding item at position $position: ${proposal[position].game}")
        holder.binding.txtProposal.text = proposal[position].game
        holder.binding.txtStatus.text = proposal[position].status
    }

    override fun getItemCount(): Int {
        return proposal.size

    }
}