package com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.dto

import jakarta.validation.constraints.NotEmpty

data class CartItemDeleteRequest(
    @field:NotEmpty(message = "itemIds must not be empty")
    val itemIds: MutableList<String>
)
