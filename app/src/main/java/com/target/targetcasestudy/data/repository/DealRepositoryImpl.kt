package com.target.targetcasestudy.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.target.targetcasestudy.api.DealService
import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.data.toProducts
import com.target.targetcasestudy.data.toProduct
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Deals
import com.target.targetcasestudy.domain.repository.DealRepository
import java.io.IOException
import javax.inject.Inject

class DealRepositoryImpl @Inject constructor(private val service: DealService) : DealRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun retrieveDeals(): Resource<Deals> {
        return try {
            val deals = service.retrieveDeals().toProducts()
            Resource.Success(deals)

        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "There was a problem retrieving the list of deals")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "There was a problem retrieving the list of deals. Please check your internet connection and try again.")
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun retrieveDeal(dealId: String): Resource<Deal> {
        return try {
            val deal = service.retrieveDeal(dealId).toProduct()
            return Resource.Success(deal)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "There was a problem retrieving this deal")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "There was a problem retrieving this deal. Please check your internet connection and try again.")
        }
    }


}