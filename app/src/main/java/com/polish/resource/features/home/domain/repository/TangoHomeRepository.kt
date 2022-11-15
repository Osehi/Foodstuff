package com.polish.resource.features.home.domain.repository

import com.polish.resource.features.home.data.network.model.getevents.GetEventsRequestBody
import com.polish.resource.features.home.data.network.model.getevents.GetEventsResponse
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListResponse
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListRequestBody
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListResponse

interface TangoHomeRepository {

    suspend fun getTeacherList(
        getTeacherListRequestBody: GetTeacherListRequestBody
    ): GetTeacherListResponse

    suspend fun getEvents(
        getEventsRequestBody: GetEventsRequestBody
    ): GetEventsResponse

    suspend fun getMilongasList(
        getMilongasListRequestBody: GetMilongasListRequestBody
    ): GetMilongasListResponse
}
