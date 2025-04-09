package com.sw.fred.data.api

import kotlinx.serialization.Serializable

/**
 * Represents a recipe from TheMealDB API.
 *
 * @property idMeal The unique identifier for the recipe.
 * @property strMeal The name of the recipe.
 * @property strMealThumb The URL of the thumbnail image for the recipe.
 * @property strCategory The category of the recipe.
 */
@Serializable
data class ApiRecipe(
    val idMeal: String = "",
    val strMeal: String = "",
    val strMealThumb: String = "",
    var strCategory: String = "",
)
