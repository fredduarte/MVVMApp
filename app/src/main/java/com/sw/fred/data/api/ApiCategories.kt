package com.sw.fred.data.api

import kotlinx.serialization.Serializable

/**
 * Represents the response from TheMealDB API for categories.
 *
 * @property categories A list of `Category` objects representing the categories of recipes.
 */
@Serializable
data class ApiCategories(
    val categories: List<ApiCategories>,
)
