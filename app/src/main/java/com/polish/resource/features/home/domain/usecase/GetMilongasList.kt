package com.polish.resource.features.home.domain.usecase

import com.polish.common.utils.resourcewrapper.Resource
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListRequestBody
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListResponse
import com.polish.resource.features.home.domain.repository.TangoHomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMilongasList @Inject constructor(
    private val tangoHomeRepository: TangoHomeRepository
) {
    operator fun invoke(getMilongasListRequestBody: GetMilongasListRequestBody): Flow<Resource<GetMilongasListResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = tangoHomeRepository.getMilongasList(getMilongasListRequestBody)
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server check your internet connection"))
        }
    }
}