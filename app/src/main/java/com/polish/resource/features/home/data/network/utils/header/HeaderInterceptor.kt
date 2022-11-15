package com.polish.resource.features.home.data.network.utils.header

import com.polish.common.constant.NetworkConstant
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer ${NetworkConstant.ACCESS_TOKEN}")
                .build()
        )
    }
}
