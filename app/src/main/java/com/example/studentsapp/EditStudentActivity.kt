package com.example.studentsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.databinding.ActivityEditStudentBinding
import com.example.studentsapp.models.Model

class EditStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentId = intent.getStringExtra("student_id")
        val student = Model.shared.students.find { it.id == studentId }

        student?.let { s ->
            // Initialize the fields with current data
            binding.editNameInput.setText(s.name)
            binding.editIdInput.setText(s.id)
            binding.editPhoneInput.setText(s.phoneNumber)
            binding.editAddressInput.setText(s.address)
            binding.editPresenceCheckbox.isChecked = s.isPresent

            // Save logic: Update data and return
            binding.saveButton.setOnClickListener {
                s.name = binding.editNameInput.text.toString()
                s.id = binding.editIdInput.text.toString()
                s.phoneNumber = binding.editPhoneInput.text.toString()
                s.address = binding.editAddressInput.text.toString()
                s.isPresent = binding.editPresenceCheckbox.isChecked
                finish()
            }

            // Delete logic: Remove from list and close activity
            binding.deleteButton.setOnClickListener {
                Model.shared.students.remove(s)
                finish()
            }
        }

        // Cancel logic: Just close the activity without saving
        binding.cancelButton.setOnClickListener {
            finish()
        }
    }
}