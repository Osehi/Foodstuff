package com.polish.resource.features.home.data.network.repository

import com.polish.resource.features.home.data.network.api.TangoHomeAPI
import com.polish.resource.features.home.data.network.model.getevents.GetEventsRequestBody
import com.polish.resource.features.home.data.network.model.getevents.GetEventsResponse
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListResponse
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListRequestBody
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListResponse
import com.polish.resource.features.home.domain.repository.TangoHomeRepository
import javax.inject.Inject

class TangoHomeRepositoryImpl @Inject constructor(
    private val tangoHomeAPI: TangoHomeAPI
) : TangoHomeRepository {
    override suspend fun getTeacherList(getTeacherListRequestBody: GetTeacherListRequestBody): GetTeacherListResponse {
        return tangoHomeAPI.getTeacherList(getTeacherListRequestBody)
    }

    override suspend fun getEvents(getEventsRequestBody: GetEventsRequestBody): GetEventsResponse {
        return tangoHomeAPI.getEvents(getEventsRequestBody)
    }

    override suspend fun getMilongasList(getMilongasListRequestBody: GetMilongasListRequestBody): GetMilongasListResponse {
        return tangoHomeAPI.getMilongasList(getMilongasListRequestBody)
    }
}
