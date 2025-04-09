package com.sw.fred.data.api

import kotlinx.serialization.Serializable

/**
 * Represents the response from TheMealDB API for recipes.
 *
 * @property meals A list of `ApiRecipe` objects representing the recipes.
 */
@Serializable
data class ApiRecipes(
    val meals: List<ApiRecipe> = listOf(),
)
