package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto;

public record SellerOrderSummaryResponse(long newOrders,
                                         long acceptedOrders,
                                         long shippingOrders,
                                         long completedOrders,
                                         long claimedOrders) {
}
