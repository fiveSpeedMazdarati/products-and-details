package com.target.targetcasestudy.data.remote

import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.data.remote.dto.DealDto
import com.target.targetcasestudy.data.remote.dto.DealsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DealService {

  @GET("${Constants.DEALS_API_ENDPOINT}deals")
  suspend fun retrieveDeals(): DealsDto

  @GET("${Constants.DEALS_API_ENDPOINT}deals/{dealId}")
  suspend fun retrieveDeal(@Path("dealId") dealId: String): DealDto
}