package com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class CartAddRequest(
    @field:NotBlank(message = "product id is required")
    var productId: String,

    @field:Min(value = 1, message = "quantity must be at least 1")
    val quantity: Int
)