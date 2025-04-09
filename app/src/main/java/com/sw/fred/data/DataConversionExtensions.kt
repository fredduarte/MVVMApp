package com.sw.fred.data

import com.sw.fred.data.api.ApiCategory
import com.sw.fred.data.domain.Category

fun ApiCategory.toDomain(): Category {
    return Category(
        id = this.idCategory,
        name = this.strCategory,
        thumbnailUrl = this.strCategoryThumb,
        description = this.strCategoryDescription
    )
}
