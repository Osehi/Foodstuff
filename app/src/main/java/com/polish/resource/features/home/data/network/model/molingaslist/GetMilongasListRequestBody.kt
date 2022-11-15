package com.polish.resource.features.home.data.network.model.molingaslist

data class GetMilongasListRequestBody(
    val day: String?,
    val lati: Double?,
    val longi: Double?,
    val milonga_name: String?,
    val offset: String?,
    val radius: Int?,
    val rating_atleast: Int?,
    val sortBy: String?
)