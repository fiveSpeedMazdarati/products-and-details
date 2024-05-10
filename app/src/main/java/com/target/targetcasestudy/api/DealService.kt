package com.target.targetcasestudy.api

import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.data.DealDto
import com.target.targetcasestudy.data.DealsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DealService {

  @GET("${Constants.DEALS_API_ENDPOINT}deals")
  suspend fun retrieveDeals(): Resource<DealsDto>

  @GET("${Constants.DEALS_API_ENDPOINT}deals/{dealId}")
  suspend fun retrieveDeal(@Path("dealId") dealId: String): Resource<DealDto>
}
