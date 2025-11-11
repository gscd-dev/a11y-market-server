package com.multicampus.gamesungcoding.a11ymarketserver.cart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CartItemsResponse {
    private final List<CartDTO> items;
    private final int total; // 합계(현재 0 계산이면 그대로 0, 나중에 조인으로 계산)
}