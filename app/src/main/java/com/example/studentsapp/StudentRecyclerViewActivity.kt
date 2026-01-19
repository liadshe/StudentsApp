package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentsapp.databinding.ActivityStudentsRecyclerViewBinding
import com.example.studentsapp.models.Model
import com.example.studentsapp.models.Student

class StudentRecyclerViewActivity : AppCompatActivity() {
    var binding : ActivityStudentsRecyclerViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStudentsRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val layout = LinearLayoutManager(this)
        binding?.recyclerView?.layoutManager = layout
        binding?.recyclerView?.setHasFixedSize(true)

        val adapter = StudentsAdapter(Model.shared.students)
        adapter.listener = object : onItemClickListener {
            override fun onItemClick(position: Int) {
                Log.d("StudentsRecyclerViewActivity", "Button clicked!")
            }

            override fun onStudentItemClick(student: Student) {
                val intent =
                    Intent(this@StudentRecyclerViewActivity, StudentDetailsActivity::class.java)

                intent.putExtra("student_id", student.id)

                startActivity(intent)
            }
        }

        binding?.recyclerView?.adapter = adapter
    }}