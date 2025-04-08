package com.sw.fred.data.api

import kotlinx.serialization.Serializable

/**
 * A data class representing a category of recipes.
 *
 * @property idCategory The unique identifier for the category.
 * @property strCategory The name of the category.
 * @property strCategoryThumb The URL of the thumbnail image for the category.
 * @property strCategoryDescription A description of the category.
 */
@Serializable
data class ApiCategory(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)
