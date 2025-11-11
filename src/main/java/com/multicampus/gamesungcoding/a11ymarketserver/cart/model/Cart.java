package com.multicampus.gamesungcoding.a11ymarketserver.cart.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID cartItemId;                 // 장바구니 아이템 PK

    @Column(nullable = false)
    private UUID cartId;

    @Column(nullable = false)
    private UUID userId;           // 사용자/회원 ID

    @Column(nullable = false)
    private UUID productId;          // 상품 ID

    @Column(nullable = false)
    private Integer quantity;        // 수량

    public void changeQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity must be >= 1");
        }
        this.quantity = quantity;
    }

    /** 장바구니 수량을 누적 증가 (양수만 허용) */
    public void increaseQuantity(int delta) {
        if (delta < 1) {
            throw new IllegalArgumentException("delta must be >= 1");
        }
        this.quantity += delta;
    }
    public CartDTO toDto() { // [ADDED]
        return CartDTO.builder()
                .cartItemId(this.getCartItemId())
                .cartId(this.getCartId())
                .productId(this.getProductId())
                .quantity(this.getQuantity())
                .build();
    }
}