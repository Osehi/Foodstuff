package com.polish.resource.features.home.data.network.model.getevents

data class Event(
    val address: String?,
    val created_at: String?,
    val distance: Double?,
    val event_details: String?,
    val event_end_date: String?,
    val event_link: String?,
    val event_name: String?,
    val event_start_date: String?,
    val id: Int?,
    val images: List<Image?>,
    val lati: String?,
    val longi: String?,
    val status: String?,
    val updated_at: String?
)