package com.sw.fred.data.repository

import com.sw.fred.data.domain.Category
import com.sw.fred.data.network.MealDbApi
import com.sw.fred.data.toDomain
import javax.inject.Inject

class MealDbRepository @Inject constructor(
    private val apiService: MealDbApi,
) {

    suspend fun getCategories(): List<Category> {
        return apiService.getCategories().categories.map { category ->
            category.toDomain()
        }
    }
}
