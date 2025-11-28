package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.model;

import java.util.UUID;

public record ProductDetailResponse(UUID productId,
                                    String productName,
                                    Integer productPrice,
                                    String productStatus,
                                    String productImageUrl,
                                    String productDescription,
                                    String summaryText,
                                    String usageContext,
                                    String usageMethod) {
}
