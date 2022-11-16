package com.polish.resource.features.home.data.network.model.getevents

data class GetEventsRequestBody(
    val lati: Double? = 30.40,
    val longi: Double? = 65.80,
    val offset: String? = "0"
)
