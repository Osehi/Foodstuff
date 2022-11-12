package com.polish.resource.features.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polish.resource.databinding.TeachersListItemBinding
import com.polish.resource.features.mock.Teachers

class TeacherAdapter(val allTeachers: List<Teachers>) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>(){

    class TeacherViewHolder(private val binding: TeachersListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(teacher: Teachers, context: Context) {
            // initialize the views and bind
            Glide.with(context).load(teacher.image).into(binding.teachersListItemPhotoIv)
            binding.teachersListItemTitleTv.text = teacher.name
            binding.teachersListItemRatingTv.text = teacher.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = TeachersListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val currentItem = allTeachers[position]
        holder.bind(currentItem, holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return allTeachers.size
    }
}