package com.polish.resource.features.home.data.network.model.getevents

data class GetEventsResponse(
    val Event_List: List<Event?>?,
    val message: String?,
    val offset: Int?,
    val status: Boolean?,
    val user_access: Int?
)