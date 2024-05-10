package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.api.DealService
import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.data.DealDto
import com.target.targetcasestudy.data.DealsDto
import com.target.targetcasestudy.domain.repository.DealRepository
import javax.inject.Inject

class DealRepositoryImpl @Inject constructor(private val service: DealService) : DealRepository {
    override suspend fun retrieveDeals(): Resource<DealsDto> {
        return service.retrieveDeals()
    }

    override suspend fun retrieveDeal(dealId: String): Resource<DealDto> {
        return service.retrieveDeal(dealId)
    }


}