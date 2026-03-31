package com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.entity.CartItems
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.entity.Product
import java.util.*

data class CartItemDto(
    val cartItemId: UUID?,
    val cartId: UUID?,
    val productId: UUID,
    val sellerId: UUID,
    val sellerName: String,
    val productName: String,
    val productPrice: Int,
    val categoryName: String,
    val quantity: Int,
    val productImageUrl: String?
) {

    companion object {
        fun fromEntity(cartItems: CartItems): CartItemDto {
            val cart = cartItems.cart
            val product = cartItems.product
            val seller = product.seller

            val productImageUrl = if (product.productImages.isEmpty()) {
                null
            } else {
                product.productImages.first().imageUrl
            }

            return CartItemDto(
                cartItems.cartItemId,
                cart.cartId,
                product.productId,
                seller.sellerId,
                seller.sellerName,
                product.productName,
                product.productPrice,
                product.category.categoryName,
                cartItems.quantity,
                productImageUrl
            )
        }

        @JvmStatic
        fun of(product: Product, quantity: Int): CartItemDto {
            val seller = product.seller

            return CartItemDto(
                null,
                null,
                product.productId,
                seller.sellerId,
                seller.sellerName,
                product.productName,
                product.productPrice,
                product.category.categoryName,
                quantity,
                if (product.productImages.isEmpty())
                    null
                else
                    product.productImages.first().imageUrl
            )
        }
    }
}