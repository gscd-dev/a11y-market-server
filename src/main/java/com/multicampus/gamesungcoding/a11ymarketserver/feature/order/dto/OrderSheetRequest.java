package com.multicampus.gamesungcoding.a11ymarketserver.feature.order.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderSheetRequest {
    private List<String> cartItemIds;
    private OrderRequestItem directOrderItem;

    public boolean isFromCart() {
        return cartItemIds != null && !cartItemIds.isEmpty();
    }

    @Override
    public String toString() {
        return "OrderSheetRequest{" +
                "cartItemIds=" + cartItemIds +
                ", directOrderItem=" + directOrderItem +
                '}';
    }
}
