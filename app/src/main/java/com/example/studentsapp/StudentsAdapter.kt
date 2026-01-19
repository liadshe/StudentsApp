package com.example.studentsapp
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.databinding.StudentRowLayoutBinding
import com.example.studentsapp.models.Student
import kotlin.text.get

interface onItemClickListener{
    fun onItemClick(position: Int)
    fun onStudentItemClick(student: Student)
}
class StudentsAdapter(
    private var students: List<Student>,
) : RecyclerView.Adapter<StudentRowViewHolder>() {

    var listener: onItemClickListener? = null
    override fun getItemCount(): Int = students.size

    // return the class of the row
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentRowViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = StudentRowLayoutBinding.inflate(inflator, parent, false)
        return StudentRowViewHolder(
            binding,
            listener = listener
        )

    }
    override fun onBindViewHolder(
        holder: StudentRowViewHolder,
        position: Int
    ) {
        val student = students[position]

        holder.bind(student, position)

        holder.itemView.setOnClickListener {
            listener?.onStudentItemClick(student)
        }
    }
}





