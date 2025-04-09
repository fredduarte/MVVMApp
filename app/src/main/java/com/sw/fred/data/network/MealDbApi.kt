package com.sw.fred.data.network

import com.sw.fred.data.api.ApiCategories
import com.sw.fred.data.api.ApiRecipes
import retrofit2.http.GET
import retrofit2.http.Query

interface MealDbApi {

    @GET("categories.php")
    suspend fun getCategories(): ApiCategories

    @GET("filter.php")
    suspend fun getRecipesByCategory(
        @Query("c") category: String,
    ) : ApiRecipes
}
