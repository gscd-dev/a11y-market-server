package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.ImageMetadata
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.entity.ProductStatus
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class SellerProductUpdateRequest(
    @field:NotBlank val productName: String,
    @field:NotBlank val productDescription: String,
    @field:NotBlank val categoryId: String,
    @field:Min(0) val productPrice: Int,
    @field:Min(0) val productStock: Int,
    val productStatus: ProductStatus,
    val imageMetadataList: List<ImageMetadata>? = null
)
