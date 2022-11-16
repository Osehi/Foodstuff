package com.polish.resource.features.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polish.resource.R
import com.polish.resource.databinding.TeachersListItemBinding
import com.polish.resource.features.home.data.network.model.getteacherlist.Teacher
import com.polish.resource.features.mock.Teachers

class TeacherAdapter(val allTeachers: List<Teacher>) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>(){

    class TeacherViewHolder(private val binding: TeachersListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(teacher: Teacher, context: Context) {
            // initialize the views and bind
            Glide.with(context).load(teacher.teacher_image)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.teachersListItemPhotoIv)
            binding.teachersListItemTitleTv.text = teacher.teacher_name
            binding.teachersListItemRatingTv.text = teacher.teacher_rating.toString()
            binding.teachersListItemDurationExperienceTv.text = teacher.year_of_experience.toString()
            binding.teachersListItemDirectionTv.text = teacher.distance
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