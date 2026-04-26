package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderItemStatus

data class SellerOrderItemsStatusUpdateRequest(
    val status: OrderItemStatus
)
