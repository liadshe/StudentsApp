package com.example.studentsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.databinding.ActivityAddStudentBinding
import com.example.studentsapp.models.Model
import com.example.studentsapp.models.Student

class AddStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Cancel Button: Just close the activity
        binding.cancelButton.setOnClickListener {
            finish()
        }

        // 2. Save Button: Create new student
        binding.saveButton.setOnClickListener {
            saveStudent()
        }
    }

    private fun saveStudent() {
        // A. Get text from inputs
        val name = binding.addStudentNameEt.text.toString()
        val id = binding.addStudentIdEt.text.toString()
        val phone = binding.addStudentPhoneEt.text.toString()
        val address = binding.addStudentAddressEt.text.toString()
        val isCheckedIn = binding.addStudentCheckedInCb.isChecked

        // B. Simple validation (make sure they aren't empty)
        if (name.isBlank() || id.isBlank()) {
            Toast.makeText(this, "Please enter Name and ID", Toast.LENGTH_SHORT).show()
            return
        }

        // C. Create the new Student Object
        val newStudent = Student(
            name = name,
            id = id,
            pic = R.drawable.avatar, // Default image
            isPresent = isCheckedIn,
            phoneNumber = phone,
            address = address
        )

        // D. Add to Global Model
        Model.shared.students.add(newStudent)

        // E. Close screen (Go back to list)
        finish()
    }
}