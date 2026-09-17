package com.ute.studentprofile.validation

object GpaValidator {

    private const val MIN_GPA = 0.0
    private const val MAX_GPA = 4.0

    fun parseAndValidate(input: String): Double? {
        val gpa = input.toDoubleOrNull() ?: return null
        return if (gpa in MIN_GPA..MAX_GPA) gpa else null
    }
}
