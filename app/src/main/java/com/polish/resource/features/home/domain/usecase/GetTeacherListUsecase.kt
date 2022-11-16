package com.polish.resource.features.home.domain.usecase

import com.polish.common.utils.resourcewrapper.Resource
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListResponse
import com.polish.resource.features.home.domain.repository.TangoHomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeacherListUsecase @Inject constructor(
    private val tangoHomeRepository: TangoHomeRepository
) {
    operator fun invoke(getTeacherListRequestBody: GetTeacherListRequestBody): Flow<Resource<GetTeacherListResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = tangoHomeRepository.getTeacherList(getTeacherListRequestBody)
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server check your internet connection"))
        }
    }
}