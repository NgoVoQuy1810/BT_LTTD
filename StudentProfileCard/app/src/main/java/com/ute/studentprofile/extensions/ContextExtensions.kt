package com.ute.studentprofile.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.dialPhoneNumber(phoneNumber: String) {
    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    startActivity(dialIntent)
}

fun Context.showConfirmDialog(
    title: String,
    message: String,
    positiveButtonText: String = "Xóa",
    negativeButtonText: String = "Hủy",
    onConfirm: () -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(positiveButtonText) { _, _ ->
            onConfirm()
        }
        .setNegativeButton(negativeButtonText, null)
        .show()
}
