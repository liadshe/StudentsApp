package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.databinding.ActivityStudentDetailsBinding // Auto-generated
import com.example.studentsapp.models.Model

class StudentDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentDetailsBinding
    private var studentId: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentId = intent.getStringExtra("student_id")

        binding.backButton.setOnClickListener {
            finish()
        }

        // 2. Set up the Edit Button listener
        binding.editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("student_id", studentId)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        refreshUI()
    }

    private fun refreshUI() {
        val student = Model.shared.students.firstOrNull { it.id == studentId }

        if (student == null) {
            finish()
        } else {
            binding.studentNameTextView.text = student.name
            binding.studentIdTextView.text = student.id
            binding.studentIsPresentCheckbox.isChecked = student.isPresent
            binding.studentDetailsImage.setImageResource(student.pic)
            binding.studentPhoneTextView.text = student.phoneNumber
            binding.studentAddressTextView.text = student.address

            binding.studentIsPresentCheckbox.setOnCheckedChangeListener { _, isChecked ->
                student.isPresent = isChecked
            }
        }
    }
}