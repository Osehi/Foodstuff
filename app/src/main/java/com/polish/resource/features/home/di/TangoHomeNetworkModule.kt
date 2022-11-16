package com.polish.resource.features.home.di

import com.polish.resource.features.home.data.network.api.TangoHomeAPI
import com.polish.resource.features.home.data.network.repository.TangoHomeRepositoryImpl
import com.polish.resource.features.home.domain.repository.TangoHomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TangoHomeNetworkModule {

    @Provides
    @Singleton
    fun provideTangoHomeApi(retrofit: Retrofit): TangoHomeAPI {
        return retrofit.create(TangoHomeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideTangoHomeRepository(tangoHomeAPI: TangoHomeAPI): TangoHomeRepository {
        return TangoHomeRepositoryImpl(tangoHomeAPI)
    }
}