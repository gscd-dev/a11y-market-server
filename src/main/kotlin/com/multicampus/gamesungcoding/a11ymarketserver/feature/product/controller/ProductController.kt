package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.controller

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.ProductDetailResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.ProductResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.service.ProductService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping("/")
    fun getProducts(
        @RequestParam(required = false) search: String?,
        @RequestParam(required = false) certified: Boolean?,
        @RequestParam(required = false) grade: String?,
        @RequestParam(required = false) categoryId: List<String>?
    ): List<ProductResponse> {
        return productService.getProducts(search, certified, grade, categoryId)
    }

    @GetMapping("/{productId}")
    fun getProductDetail(
        @PathVariable productId: String
    ): ProductDetailResponse {
        return productService.getProductDetail(UUID.fromString(productId))

    }
}

