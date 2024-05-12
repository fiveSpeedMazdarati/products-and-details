package com.target.targetcasestudy.domain.use_case

import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.domain.model.Deals
import com.target.targetcasestudy.domain.repository.DealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDealsUseCase @Inject constructor(
    private val repository: DealRepository
) {

    operator fun invoke(): Flow<Resource<Deals>> = flow {

        emit(Resource.Loading())

        val deals = repository.retrieveDeals()

        deals.data?.let {
            emit(Resource.Success(deals.data))
        }

        if (deals is Resource.Error) {
            emit(Resource.Error(deals.message ?: "", null))
        }
    }

}