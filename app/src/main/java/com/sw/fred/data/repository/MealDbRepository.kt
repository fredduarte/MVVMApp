package com.sw.fred.data.repository

import com.sw.fred.data.domain.Category
import com.sw.fred.data.domain.Recipe
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

    suspend fun getRecipesByCategory(category: String): List<Recipe> {
        return apiService.getRecipesByCategory(category).meals.map { recipe ->
            recipe.toDomain()
        }
    }
}
