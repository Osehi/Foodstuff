package com.polish.resource.features.mock

import androidx.annotation.DrawableRes
import com.polish.resource.R

data class Milongas(
    @DrawableRes val image: Int = R.drawable.milongasitemone,
    val cardName: String = "Lakus",
    val rating: Double = 5.0,
) {
    fun generateMilongasInfo(): List<Milongas> {
        val milongasList = mutableListOf<Milongas>()
        for (i in 1..10) {
            milongasList.add(Milongas())
        }
        return milongasList
    }
}

