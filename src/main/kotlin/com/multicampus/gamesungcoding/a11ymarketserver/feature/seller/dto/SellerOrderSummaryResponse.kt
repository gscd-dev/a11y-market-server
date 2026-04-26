package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

data class SellerOrderSummaryResponse(
    val newOrders: Long,
    val acceptedOrders: Long,
    val shippingOrders: Long,
    val completedOrders: Long,
    val claimedOrders: Long
)
