package com.example.studentsapp.models

import com.example.studentsapp.R

class Model private constructor() {

    val students = mutableListOf<Student>()

    init {
        for (i in 1..20) {
            val student = Student(
                name = "Student $i",
                id = "ID${1000 + i}",
                pic = R.drawable.avatar,
                isPresent = false,
                phoneNumber = "053-5381648",
                address = "ben gurion 100"
            )
            students.add(student)
        }
    }
    companion object{
        val shared = Model() // define a singleton instance of the Model class
    }
}