package com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.dto

import jakarta.validation.constraints.Min

data class CartQtyUpdateRequest(
    @field:Min(message = "Quantity must be at least 1.", value = 1)
    val quantity: Int
)