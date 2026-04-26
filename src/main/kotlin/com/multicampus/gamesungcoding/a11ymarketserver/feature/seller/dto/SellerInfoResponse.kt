package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.ProductResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerGrades
import java.util.UUID

data class SellerInfoResponse(
    val sellerId: UUID,
    val sellerName: String,
    val businessNumber: String,
    val sellerIntro: String?,
    val sellerEmail: String,
    val sellerPhone: String,
    val isA11yGuarantee: Boolean,
    val sellerGrade: SellerGrades,
    val products: List<ProductResponse>
)
