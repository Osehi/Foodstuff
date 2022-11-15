package com.polish.resource.features.mock

import androidx.annotation.DrawableRes
import com.polish.resource.R

data class Teachers(
    @DrawableRes val image: Int = R.drawable.clari,
    val name: String = "Ines Muzzopapos",
    val rating: Double = 5.0
) {
    fun getTeachersList(): List<Teachers> {
        val teachersList = mutableListOf<Teachers>()
        for (i in 1..10) {
            teachersList.add(Teachers())
        }
        return teachersList
    }
}
