package com.ubaya.projectutsnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.databinding.SchedulePageeBinding

class EventAdapter() : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    class EventViewHolder(val binding:SchedulePageeBinding)
        :RecyclerView.ViewHolder(binding.root) {
        fun bind(event: EventBank) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = SchedulePageeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return EventData.event.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = EventData.event[position]
        holder.bind(event)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ScheduleDetailActivity::class.java)
            intent.putExtra("EVENT_NAME", event.judul)
            intent.putExtra("EVENT_TGL", event.tgl)
            intent.putExtra("EVENT_TIM", event.tim)
            intent.putExtra("EVENT_IMAGE", event.image)
            intent.putExtra("EVENT_DESC", event.desc)
            context.startActivity(intent)
        }
        holder.binding.eventDate.text = EventData.event[position].tgl
        holder.binding.eventTitle.text = EventData.event[position].judul
        holder.binding.eventTeam.text = EventData.event[position].tim
    }
}