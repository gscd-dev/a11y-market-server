package com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.entity.CartItems
import java.util.*

data class CartItemUpdatedResponse(
    val cartItemId: UUID,
    val cartId: UUID,
    val productId: UUID,
    val quantity: Int
) {
    companion object {
        fun fromEntity(cartItems: CartItems): CartItemUpdatedResponse {
            return CartItemUpdatedResponse(
                cartItems.cartItemId,
                cartItems.cart.cartId,
                cartItems.product.productId,
                cartItems.quantity
            )
        }
    }
}
