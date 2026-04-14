package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto

import java.util.*

class CategoryResponse(
    val categoryId: UUID,
    val categoryName: String
) {
    val subCategories = arrayListOf<CategoryResponse>()

    fun addSubCategory(subCategory: CategoryResponse) {
        this.subCategories.add(subCategory)
    }
}
