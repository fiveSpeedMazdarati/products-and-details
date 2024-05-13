package com.target.targetcasestudy.domain.repository

import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Deals

interface DealRepository {

    suspend fun retrieveDeals() : Resource<Deals>

    suspend fun retrieveDeal(dealId: String) : Resource<Deal>
}