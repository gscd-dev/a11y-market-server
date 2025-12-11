package com.multicampus.gamesungcoding.a11ymarketserver.feature.order.dto;

import java.util.List;

public record OrderSheetResponse(List<OrderItemResponse> items,
                                 Integer totalAmount,
                                 Integer shippingFee,
                                 Integer finalAmount) {
}
