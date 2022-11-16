package com.polish.resource.features.home.data.network.api

import com.polish.resource.features.home.data.network.model.getevents.GetEventsRequestBody
import com.polish.resource.features.home.data.network.model.getevents.GetEventsResponse
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListResponse
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListRequestBody
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface TangoHomeAPI {

    @POST("GetTeacherList")
    suspend fun getTeacherList(
        @Body getTeacherListRequestBody: GetTeacherListRequestBody
    ): GetTeacherListResponse

    @POST("GetEvents")
    suspend fun getEvents(
        @Body getEventsRequestBody: GetEventsRequestBody
    ): GetEventsResponse

    @POST("GetMillongsList")
    suspend fun getMilongasList(
        @Body getMilongasListRequestBody: GetMilongasListRequestBody
    ): GetMilongasListResponse
}