package com.polish.resource.features.home.data.network.model.getteacherlist

data class GetTeacherListRequestBody(
    val available_day: String? = "",
    val available_slot: String? = "",
    val first_name: String? = "",
    val language: String? = "",
    val lati: Double? = 30.40,
    val lesson_type: String? = "both",
    val longi: Double? = 65.80,
    val max_price: String? = "20000",
    val max_year_of_experience: Int? = 31,
    val min_price: String? = "100",
    val min_year_of_experience: Int? = 0,
    val offset: String? = "0",
    val primary_role: String? = "",
    val rating_atleast: Int? = 0,
    val sortBy: String? = "rating"
)
