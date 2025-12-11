package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto;

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.dto.ProductResponse;
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.Seller;
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerGrades;

import java.util.List;
import java.util.UUID;

public record SellerInfoResponse(UUID sellerId,
                                 String sellerName,
                                 String businessNumber,
                                 String sellerIntro,
                                 String sellerEmail,
                                 String sellerPhone,
                                 Boolean isA11yGuarantee,
                                 SellerGrades sellerGrade,
                                 List<ProductResponse> products) {

    public static SellerInfoResponse fromEntity(Seller seller) {
        var user = seller.getUser();
        var products = seller.getProducts().stream()
                .map(ProductResponse::fromEntity)
                .toList();

        return new SellerInfoResponse(
                seller.getSellerId(),
                seller.getSellerName(),
                seller.getBusinessNumber(),
                seller.getSellerIntro(),
                user.getUserEmail(),
                user.getUserPhone(),
                seller.getIsA11yGuarantee(),
                seller.getSellerGrade(),
                products
        );
    }
}
