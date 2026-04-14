package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.mapper

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.CategoryResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.entity.Categories

fun Categories.toResponse(): CategoryResponse = CategoryResponse(
    categoryId = requireNotNull(this.categoryId) { "Missing category ID" },
    categoryName = this.categoryName
)