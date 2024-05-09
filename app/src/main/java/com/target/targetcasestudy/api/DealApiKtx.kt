package com.target.targetcasestudy.api

import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.data.remote.Deal
import com.target.targetcasestudy.data.remote.DealResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DealApiKtx {

  @GET("${Constants.DEALS_API_ENDPOINT}deals")
  suspend fun retrieveDeals(): DealResponse

  @GET("${Constants.DEALS_API_ENDPOINT}deals/{dealId}")
  suspend fun retrieveDeal(@Path("dealId") dealId: String): Deal
}
