package com.ute.studentprofile.extensions

import com.ute.studentprofile.databinding.ActivityMainBinding
import com.ute.studentprofile.model.Student

fun ActivityMainBinding.bindStudent(student: Student) {
    with(this) {
        tvName.text = student.name
        tvStudentId.text = "MSSV: ${student.id} \u2022 Lớp: ${student.className}"
        tvPhone.text = "SĐT: ${student.phone}"
        tvGpaBadge.text = "${student.gpa} GPA (${student.gpa.toAcademicRanking()})"
        edtNewGpa.setText(student.gpa.toString())
    }
}

fun ActivityMainBinding.clearStudentData() {
    with(this) {
        tvName.text = ""
        tvStudentId.text = ""
        tvPhone.text = ""
        tvGpaBadge.text = ""
        edtNewGpa.setText("")
    }
}
