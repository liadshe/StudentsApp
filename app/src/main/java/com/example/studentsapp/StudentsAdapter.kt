package com.example.studentsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.databinding.StudentRowLayoutBinding
import com.example.studentsapp.models.Student

interface onItemClickListener {
    fun onItemClick(position: Int)
    fun onStudentItemClick(student: Student)
}

class StudentsAdapter(
    private var students: List<Student>,
) : RecyclerView.Adapter<StudentRowViewHolder>() {

    var listener: onItemClickListener? = null

    override fun getItemCount(): Int = students.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentRowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StudentRowLayoutBinding.inflate(inflater, parent, false)
        return StudentRowViewHolder(binding, listener)
    }

    override fun onBindViewHolder(
        holder: StudentRowViewHolder,
        position: Int
    ) {
        val student = students[position]
        holder.bind(student, position)
    }
}
