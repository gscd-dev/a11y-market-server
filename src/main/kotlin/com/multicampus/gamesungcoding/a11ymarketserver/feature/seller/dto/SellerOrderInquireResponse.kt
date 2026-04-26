package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

data class SellerOrderInquireResponse(
    val orderItems: List<SellerOrderItemResponse>,
    val totalOrderCount: Int
)
