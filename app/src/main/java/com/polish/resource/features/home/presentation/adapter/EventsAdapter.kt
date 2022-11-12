package com.polish.resource.features.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polish.resource.databinding.EventsListItemBinding
import com.polish.resource.features.mock.Events

class EventsAdapter(private val allEvents: List<Events>) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    class EventViewHolder(private val binding: EventsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(events: Events, context: Context) {
            // initialize the views and bind
            Glide.with(context).load(events.image).into(binding.eventsListItemEventIv)
            binding.eventsListItemEventDateTv.text = events.date
            binding.eventsListItemEventNameTv.text = events.nameOfEvent
            binding.eventsListItemEventLocationTv.text = events.eventLocation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = EventsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentItem = allEvents[position]
        holder.bind(currentItem, holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return allEvents.size
    }
}
