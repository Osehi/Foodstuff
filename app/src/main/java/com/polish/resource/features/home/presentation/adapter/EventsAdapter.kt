package com.polish.resource.features.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polish.resource.R
import com.polish.resource.databinding.EventsListItemBinding
import com.polish.resource.features.home.data.network.model.getevents.Event

class EventsAdapter(private val allEvents: List<Event>) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    class EventViewHolder(private val binding: EventsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(events: Event, context: Context) {
            // initialize the views and bind
            if (events.images.isNotEmpty()) {
                val imageItem = events.images[0]?.imageUrl
                Glide.with(context).load(imageItem)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(binding.eventsListItemEventIv)
            }

            binding.eventsListItemEventDateTv.text = events.event_start_date
            binding.eventsListItemEventNameTv.text = events.event_name
            binding.eventsListItemEventLocationTv.text = events.address
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
