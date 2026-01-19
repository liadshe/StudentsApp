package com.example.studentsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.databinding.ActivityStudentDetailsBinding // Auto-generated
import com.example.studentsapp.models.Model

class StudentDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflate the binding
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)

        // 3. Set content view to binding.root (NOT R.layout...)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }
        val studentId = intent.getStringExtra("student_id")
        val student = Model.shared.students.firstOrNull { it.id == studentId }

        student?.let {
            // 4. Access views directly via 'binding' (CamelCase IDs)
            binding.studentNameTextView.text = it.name
            binding.studentIdTextView.text = it.id
            binding.studentIsPresentCheckbox.isChecked = it.isPresent
            binding.studentDetailsImage.setImageResource(it.pic)
            binding.studentPhoneTextView.text = it.phoneNumber
            binding.studentAddressTextView.text = it.address

            // Handle checkbox logic
            binding.studentIsPresentCheckbox.setOnCheckedChangeListener { _, isChecked ->
                it.isPresent = isChecked
            }
        }
    }
}