package com.example.studentsapp

import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.databinding.StudentRowLayoutBinding
import com.example.studentsapp.models.Student

class StudentRowViewHolder(
    private val binding: StudentRowLayoutBinding,
    private val listener: onItemClickListener?
): RecyclerView.ViewHolder(binding.root) {

    private val student: Student? = null
    init {
        binding.checkbox.setOnClickListener { view ->
            (view?.tag as? Int)?.let { tag ->
                student?.isPresent = binding.checkbox.isChecked
            }
        }

        itemView.setOnClickListener {
            listener?.onItemClick(absoluteAdapterPosition)
            student?.let { student ->
                listener?.onStudentItemClick(student)
            }
        }

    }


    fun bind(student: Student, position: Int) {
        binding.nameTextView.text = student.name
        binding.idTextView.text = student.id
        binding.checkbox.apply {
            isChecked = student.isPresent
            tag = position
        }

    }
}