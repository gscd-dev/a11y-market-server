package com.multicampus.gamesungcoding.a11ymarketserver.feature.order.dto;

import com.multicampus.gamesungcoding.a11ymarketserver.feature.cart.entity.CartItems;
import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderItemStatus;
import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderItems;
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.entity.Product;

import java.util.UUID;

public record OrderItemResponse(
        UUID orderItemId,
        UUID productId,
        String productName,
        Integer productPrice,
        Integer productQuantity,
        Integer productTotalPrice,
        String productImageUrl,
        OrderItemStatus orderItemStatus,
        String cancelReason) {

    public static OrderItemResponse fromEntity(OrderItems entity) {
        int totalPrice = entity.getProductPrice() * entity.getProductQuantity();

        return new OrderItemResponse(
                entity.getOrderItemId(),
                entity.getProduct().getProductId(),
                entity.getProductName(),
                entity.getProductPrice(),
                entity.getProductQuantity(),
                totalPrice,
                entity.getProductImageUrl(),
                entity.getOrderItemStatus(),
                entity.getCancelReason()
        );
    }

    public static OrderItemResponse fromEntity(CartItems entity) {
        var product = entity.getProduct();
        var totalPrice = product.getProductPrice() * entity.getQuantity();

        return new OrderItemResponse(
                null,
                product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                entity.getQuantity(),
                totalPrice,
                null,
                null,
                null
        );
    }

    public static OrderItemResponse of(Product product, int quantity) {
        var totalPrice = product.getProductPrice() * quantity;

        return new OrderItemResponse(
                null,
                product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                quantity,
                totalPrice,
                null,
                null,
                null
        );
    }
}
