package com.ute.studentprofile.extensions

import android.view.View
import android.widget.EditText

fun Double.toAcademicRanking(): String = when {
    this >= 3.6 -> "Xuất sắc!!"
    this >= 3.2 -> "Giỏi"
    this >= 2.5 -> "Khá"
    else -> "Trung bình"
}

fun EditText.trimmedText(): String = text?.toString()?.trim().orEmpty()

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
