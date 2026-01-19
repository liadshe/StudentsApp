package com.example.studentsapp.models

import android.R

data class Student(
    var name: String?,
    var id: String?,
    val pic: Int,
    var isPresent: Boolean,
    var phoneNumber:String?,
    var address:String?)