package com.ute.studentprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.studentprofile.databinding.ActivityMainBinding
import com.ute.studentprofile.extensions.bindStudent
import com.ute.studentprofile.extensions.clearStudentData
import com.ute.studentprofile.extensions.dialPhoneNumber
import com.ute.studentprofile.extensions.showConfirmDialog
import com.ute.studentprofile.extensions.toast
import com.ute.studentprofile.extensions.trimmedText
import com.ute.studentprofile.model.Student
import com.ute.studentprofile.validation.GpaValidator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentStudent = Student(
        id = "2415053122236",
        name = "Ngô Võ Quý",
        className = "24T2",
        email = "ngovoquy2006@gmail.com",
        phone = "0935922061",
        gpa = 3.00
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupListeners()
    }

    private fun setupUI() {
        binding.bindStudent(currentStudent)
    }

    private fun setupListeners() {
        with(binding) {
            // Sự kiện Cập nhật GPA
            btnUpdateGpa.setOnClickListener {
                handleUpdateGpa()
            }

            // Bài tập 1: Sự kiện Gọi điện
            btnCall.setOnClickListener {
                dialPhoneNumber(currentStudent.phone)
            }

            // Bài tập 2: Sự kiện Xóa hồ sơ
            btnDelete.setOnClickListener {
                handleDeleteProfile()
            }
        }
    }

    private fun handleUpdateGpa() {
        val inputStr = binding.edtNewGpa.trimmedText()
        val validGpa = GpaValidator.parseAndValidate(inputStr)

        if (validGpa == null) {
            binding.edtNewGpa.error = "Vui lòng nhập GPA hợp lệ (0.0 - 4.0)"
            toast("Điểm GPA không hợp lệ!")
            return
        }

        // Cập nhật sinh viên bằng hàm copy() của data class
        currentStudent = currentStudent.copy(gpa = validGpa)
        binding.bindStudent(currentStudent)

        toast("Cập nhật điểm thành công!")
    }

    private fun handleDeleteProfile() {
        showConfirmDialog(
            title = "Xác nhận xóa",
            message = "Bạn có chắc chắn muốn xóa hồ sơ sinh viên ${currentStudent.name}?"
        ) {
            binding.clearStudentData()
            toast("Đã xóa hồ sơ thành công!")
        }
    }
}