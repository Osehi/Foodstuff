package com.polish.resource.features.home.data.network.model.getteacherlist

data class GetTeacherListRequestBody(
    val available_day: String?,
    val available_slot: String?,
    val first_name: String?,
    val language: String?,
    val lati: Double?,
    val lesson_type: String?,
    val longi: Double?,
    val max_price: String?,
    val max_year_of_experience: Int?,
    val min_price: String?,
    val min_year_of_experience: Int?,
    val offset: String?,
    val primary_role: String?,
    val rating_atleast: Int?,
    val sortBy: String?
)