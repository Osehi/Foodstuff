package com.polish.resource.features.home.data.network.model.molingaslist

data class GetMilongasListResponse(
    val message: String?,
    val milongas_list: List<Milongas>,
    val offset: Int?,
    val status: Boolean?,
    val user_access: Int?
)