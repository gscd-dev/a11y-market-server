package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.service

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.CategoryResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.repository.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    @Transactional(readOnly = true)
    fun getAllCategories(): List<CategoryResponse> {
        val categories = categoryRepository.findAll()

        val categoryMap = categories.map { CategoryResponse.fromEntity(it) }
            .associateBy { it.categoryId }

        val roots = ArrayList<CategoryResponse>()

        for (category in categories) {
            val currentDto = categoryMap[category.categoryId] ?: continue

            if (category.parentCategory == null) {
                roots.add(currentDto)
            } else {
                val parentId = category.parentCategory.categoryId
                val parentDto = categoryMap[parentId]

                parentDto?.addSubCategory(currentDto)
            }
        }

        return roots
    }
}
