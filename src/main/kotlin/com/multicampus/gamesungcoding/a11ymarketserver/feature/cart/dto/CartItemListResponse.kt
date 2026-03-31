package com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.dto

import jakarta.validation.constraints.Positive

data class CartItemListResponse(
    val items: List<CartItemListDto>,

    @field:Positive(message = "Total must be positive")
    val total: Int
)