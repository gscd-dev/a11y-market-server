package com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.dto

import java.util.*

data class CartItemUpdatedResponse(
    val cartItemId: UUID,
    val cartId: UUID,
    val productId: UUID,
    val quantity: Int
)
