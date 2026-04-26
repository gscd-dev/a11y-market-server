package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import java.math.BigDecimal
import java.util.UUID

data class SellerTopProductResponse(
    val sellerId: UUID,
    val productId: UUID,
    val productName: String,
    val productPrice: Int,
    val productImageUrl: String?,
    val orderCount: Long,
    val totalQuantitySold: Long,
    val totalSalesAmount: BigDecimal,
    val salesRank: Int
)
