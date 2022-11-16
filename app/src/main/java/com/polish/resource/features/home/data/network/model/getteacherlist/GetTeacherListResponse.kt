package com.polish.resource.features.home.data.network.model.getteacherlist

data class GetTeacherListResponse(
    val message: String?,
    val offset: Int?,
    val status: Boolean?,
    val teacher_count: Int?,
    val teacher_list: List<Teacher?>?,
    val user_access: Int?
)