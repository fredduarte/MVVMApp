package com.sw.fred.data.network

import com.sw.fred.data.api.ApiCategories
import retrofit2.http.GET

interface MealDbApi {

    @GET("categories.php")
    suspend fun getCategories(): ApiCategories
}
