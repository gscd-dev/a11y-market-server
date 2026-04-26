package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.mapper

import com.multicampus.gamesungcoding.a11ymarketserver.common.exception.DataNotFoundException
import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.dto.OrderItemResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderItems
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto.SellerOrderItemResponse

fun OrderItems.toSellerOrderItemResponse(): SellerOrderItemResponse {
    val order = this.order ?: throw DataNotFoundException("Order info not found")
    val product = this.product ?: throw DataNotFoundException("Product info not found")

    return SellerOrderItemResponse(
        orderItemId = this.orderItemId ?: throw DataNotFoundException("OrderItem ID is missing"),
        orderId = order.orderId ?: throw DataNotFoundException("Order ID is missing"),
        productId = product.productId ?: throw DataNotFoundException("Product ID is missing"),
        productName = this.productName ?: "Unknown Product",
        productPrice = this.productPrice,
        productQuantity = this.productQuantity,
        orderItemStatus = this.orderItemStatus,
        buyerName = order.userName,
        buyerEmail = order.userEmail,
        buyerPhone = order.userPhone,
        orderedAt = order.createdAt
    )
}

fun OrderItems.toOrderItemResponse(): OrderItemResponse {
    val product = this.product ?: throw DataNotFoundException("Product info not found")

    return OrderItemResponse(
        this.orderItemId ?: throw DataNotFoundException("OrderItem ID is missing"),
        product.productId ?: throw DataNotFoundException("Product ID is missing"),
        this.productName ?: "Unknown Product",
        product.category?.categoryName ?: throw DataNotFoundException("Product category name is missing"),
        this.productPrice,
        this.productQuantity,
        this.productQuantity * this.productPrice,
        product.productImages[0].imageUrl ?: throw DataNotFoundException("Product image URL is missing"),
        this.orderItemStatus,
        this.cancelReason
    )
}
