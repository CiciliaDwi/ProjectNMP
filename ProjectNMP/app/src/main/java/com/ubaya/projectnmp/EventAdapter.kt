package com.ubaya.projectutsnmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.ActivityScheduleListBinding

class EventAdapter() : RecyclerView.Adapter<EventAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding:ActivityScheduleListBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = ActivityScheduleListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return EventData.event.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.binding.eventDate.text = EventData.event[position].tgl
        holder.binding.eventTitle.text = EventData.event[position].judul
        holder.binding.eventTeam.text = EventData.event[position].tim
    }
}