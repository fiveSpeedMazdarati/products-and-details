package com.target.targetcasestudy.domain.repository

import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.data.DealDto
import com.target.targetcasestudy.data.DealsDto

interface DealRepository {

    suspend fun retrieveDeals() : Resource<DealsDto>

    suspend fun retrieveDeal(dealId: String) : Resource<DealDto>
}