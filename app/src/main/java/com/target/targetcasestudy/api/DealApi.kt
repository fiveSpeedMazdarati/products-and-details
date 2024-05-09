package com.target.targetcasestudy.api

import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.data.remote.DealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DealApi {

  @GET("${Constants.DEALS_API_ENDPOINT}deals")
  fun retrieveDeals(): Call<DealResponse>

  @GET("${Constants.DEALS_API_ENDPOINT}deals/{dealId}")
  fun retrieveDeal(@Path("dealId") dealId: String): Call<Deal>
}
