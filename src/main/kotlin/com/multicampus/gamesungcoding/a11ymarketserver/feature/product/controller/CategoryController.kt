package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.controller

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.CategoryResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping("/")
    fun allCategories(): List<CategoryResponse> =
        categoryService.getAllCategories()
}
