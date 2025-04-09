package com.sw.fred.data

import com.sw.fred.data.api.ApiCategory
import com.sw.fred.data.api.ApiRecipe
import com.sw.fred.data.domain.Category
import com.sw.fred.data.domain.Recipe

fun ApiCategory.toDomain(): Category {
    return Category(
        id = this.idCategory,
        name = this.strCategory,
        thumbnailUrl = this.strCategoryThumb,
        description = this.strCategoryDescription
    )
}

fun ApiRecipe.toDomain(): Recipe {
    return Recipe(
        id = this.idMeal,
        name = this.strMeal,
        thumbnailUrl = this.strMealThumb
    )
}
