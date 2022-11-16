package com.polish.resource.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polish.common.utils.resourcewrapper.Resource
import com.polish.resource.features.home.data.network.model.getevents.GetEventsRequestBody
import com.polish.resource.features.home.data.network.model.getevents.GetEventsResponse
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListResponse
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListRequestBody
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListResponse
import com.polish.resource.features.home.domain.usecase.GetEventsUsecase
import com.polish.resource.features.home.domain.usecase.GetMilongasList
import com.polish.resource.features.home.domain.usecase.GetTeacherListUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getTeacherListUsecase: GetTeacherListUsecase,
    private val getEventsUsecase: GetEventsUsecase,
    private val getMilongasListUsecase: GetMilongasList
) : ViewModel() {

    private val TAG = "HOMEFRAGMENTVIEWM"

    private val _getTeacherListResponse = MutableStateFlow<Resource<GetTeacherListResponse>>(Resource.Loading())
    val getTeacherListResponse: StateFlow<Resource<GetTeacherListResponse>> get() = _getTeacherListResponse

    private val _getEventResponse = MutableStateFlow<Resource<GetEventsResponse>>(Resource.Loading())
    val getEventResponse: StateFlow<Resource<GetEventsResponse>> get() = _getEventResponse

    private val _getMilongasListResponse = MutableStateFlow<Resource<GetMilongasListResponse>>(Resource.Loading())
    val getMilongasListResponse: StateFlow<Resource<GetMilongasListResponse>> get() = _getMilongasListResponse

    fun allTangoHomeInfo(
        getTeacherListRequestBody: GetTeacherListRequestBody,
        getEventsRequestBody: GetEventsRequestBody,
        getMilongasListRequestBody: GetMilongasListRequestBody
    ) {
        viewModelScope.launch {
            val getAllTeachers = async {
                getTeacherListUsecase(getTeacherListRequestBody).collect {
                    _getTeacherListResponse.value = it
                }
            }
            val getAllEvents = async {
                getEventsUsecase(getEventsRequestBody).collect {
                    _getEventResponse.value = it
                }
            }
            val getAllMilongas = async {
                getMilongasListUsecase(getMilongasListRequestBody).collect {
                    _getMilongasListResponse.value = it
                }
            }
            getAllTeachers.await()
            getAllEvents.await()
            getAllMilongas.await()
        }
    }
}
