package com.polish.resource.features.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polish.resource.databinding.MilongasListItemBinding
import com.polish.resource.features.mock.Milongas

class MilongasAdapter(val allMilongas: List<Milongas>) : RecyclerView.Adapter<MilongasAdapter.MilongasViewHolder>() {

    class MilongasViewHolder(private val binding: MilongasListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(milongas: Milongas, context: Context) {
            // initialize the views and bind
            Glide.with(context).load(milongas.image).into(binding.molingasListItemIv)
            binding.molingasListItemTitleTv.text = milongas.cardName
//            binding.milongasListItemRatingTv.text = milongas.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MilongasViewHolder {
        val view = MilongasListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MilongasViewHolder(view)
    }

    override fun onBindViewHolder(holder: MilongasViewHolder, position: Int) {
        val currentItem = allMilongas[position]
        holder.bind(currentItem, holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return allMilongas.size
    }
}
