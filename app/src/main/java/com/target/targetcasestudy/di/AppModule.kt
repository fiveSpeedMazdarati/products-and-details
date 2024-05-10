package com.target.targetcasestudy.di

import com.target.targetcasestudy.api.DealService
import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.data.repository.DealRepositoryImpl
import com.target.targetcasestudy.domain.repository.DealRepository
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

    @Provides
    @Singleton
    fun provideProductService(): DealService {
        return Retrofit.Builder()
            .baseUrl(Constants.DEALS_API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DealService::class.java)
    }

    @Provides
    @Singleton
    fun provideDealRepository(api: DealService): DealRepository {
        return DealRepositoryImpl(api)
    }
}