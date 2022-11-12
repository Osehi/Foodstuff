package com.polish.resource.features.mock

import androidx.annotation.DrawableRes
import com.polish.resource.R

data class Events(
    @DrawableRes val image: Int = R.drawable.eventsflyers,
    val date: String = "Fri.Aug 22th at 15:00 - Aug 13",
    val nameOfEvent: String = "El Cachivache Orkesta -NY Queer Tango",
    val eventLocation: String = "Hungarian House of New York - New York",
    val getInfo: String = "+ Info"

) {
    fun geneerateEvents(): List<Events> {
        val eventList = mutableListOf<Events>()
        for (i in 1..10) {
            eventList.add(Events())
        }
        return eventList
    }
}
