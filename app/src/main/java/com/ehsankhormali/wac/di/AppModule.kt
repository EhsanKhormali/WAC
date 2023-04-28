package com.ehsankhormali.wac.di

import com.ehsankhormali.wac.network.WordpressApi
import com.ehsankhormali.wac.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideWordpressApi():WordpressApi{
return Retrofit.Builder()
    .baseUrl(Constants.BASE_WORDPRESS_URL_V2)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(WordpressApi::class.java)
    }
}