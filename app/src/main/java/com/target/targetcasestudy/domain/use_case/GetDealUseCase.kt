package com.target.targetcasestudy.domain.use_case

import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.repository.DealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDealUseCase @Inject constructor(
    private val repository: DealRepository
) {

    operator fun invoke(dealId: String): Flow<Resource<Deal>> = flow {

        emit(Resource.Loading())

        val deal = repository.retrieveDeal(dealId)
        deal.data?.let {
            emit(Resource.Success(deal.data))
        }
    }

}