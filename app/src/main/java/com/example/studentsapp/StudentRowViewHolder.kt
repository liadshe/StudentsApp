package com.example.studentsapp

import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.databinding.StudentRowLayoutBinding
import com.example.studentsapp.models.Student

class StudentRowViewHolder(
    private val binding: StudentRowLayoutBinding,
    private val listener: onItemClickListener?
): RecyclerView.ViewHolder(binding.root) {

    fun bind(student: Student, position: Int) {
        // 1. Update the UI
        binding.nameTextView.text = student.name
        binding.idTextView.text = student.id

        // 2. Set the Checkbox
        // IMPORTANT: Reset the listener first to avoid bugs while scrolling (recycling)
        binding.checkbox.setOnCheckedChangeListener(null)
        binding.checkbox.isChecked = student.isPresent

        // 3. Handle Checkbox Click (Update Model)
        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            student.isPresent = isChecked
        }

        // 4. Handle Row Click (Open Activity)
        // We set this here so we have access to the specific 'student' object
        itemView.setOnClickListener {
            listener?.onStudentItemClick(student)
        }
    }
}