package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.mapper

import com.multicampus.gamesungcoding.a11ymarketserver.common.exception.DataNotFoundException
import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderItems
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.mapper.toInquireResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.mapper.toResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto.SellerApplyResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto.SellerDetailResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto.SellerInfoResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto.SellerProfileResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.Seller

fun Seller.toApplyResponse(): SellerApplyResponse {
    val user = this.user ?: throw DataNotFoundException("User info not found")
    return SellerApplyResponse(
        sellerId = this.sellerId ?: throw DataNotFoundException("Seller ID is missing"),
        sellerName = this.sellerName,
        userName = user.userName,
        userEmail = user.userEmail,
        userPhone = user.userPhone ?: throw DataNotFoundException("User phone is missing"),
        businessNumber = this.businessNumber,
        sellerGrade = this.sellerGrade,
        sellerIntro = this.sellerIntro,
        a11yGuarantee = this.isA11yGuarantee,
        sellerSubmitStatus = this.sellerSubmitStatus,
        submitDate = this.submitDate ?: throw DataNotFoundException("Submit date is missing"),
        approvedDate = this.approvedDate
    )
}

fun Seller.toInfoResponse(): SellerInfoResponse {
    val user = this.user ?: throw DataNotFoundException("User info not found")
    return SellerInfoResponse(
        sellerId = this.sellerId ?: throw DataNotFoundException("Seller ID is missing"),
        sellerName = this.sellerName,
        businessNumber = this.businessNumber,
        sellerIntro = this.sellerIntro,
        sellerEmail = user.userEmail,
        sellerPhone = user.userPhone ?: throw DataNotFoundException("User phone is missing"),
        isA11yGuarantee = this.isA11yGuarantee,
        sellerGrade = this.sellerGrade,
        products = this.products.map { it.toResponse() }
    )
}

fun Seller.toProfileResponse(): SellerProfileResponse {
    val user = this.user ?: throw DataNotFoundException("User info not found")
    return SellerProfileResponse(
        sellerId = this.sellerId ?: throw DataNotFoundException("Seller ID is missing"),
        sellerName = this.sellerName,
        businessNumber = this.businessNumber,
        sellerGrade = this.sellerGrade,
        contactEmail = user.userEmail,
        contactPhone = user.userPhone ?: throw DataNotFoundException("User phone is missing"),
        storeIntro = this.sellerIntro,
        isA11yGuarantee = this.isA11yGuarantee,
        profileStatus = this.sellerSubmitStatus,
        submitDate = this.submitDate ?: throw DataNotFoundException("Submit date is missing"),
        approvedDate = this.approvedDate,
        lastUpdatedDate = this.updatedAt
    )
}

fun Seller.toDetailResponse(ordersList: List<OrderItems>): SellerDetailResponse {
    val user = this.user ?: throw DataNotFoundException("User info not found")
    return SellerDetailResponse(
        sellerId = this.sellerId ?: throw DataNotFoundException("Seller ID is missing"),
        sellerName = this.sellerName,
        businessNumber = this.businessNumber,
        sellerGrade = this.sellerGrade,
        contactEmail = user.userEmail,
        contactPhone = user.userPhone ?: throw DataNotFoundException("User phone is missing"),
        storeIntro = this.sellerIntro,
        isA11yGuarantee = this.isA11yGuarantee,
        profileStatus = this.sellerSubmitStatus,
        submitDate = this.submitDate ?: throw DataNotFoundException("Submit date is missing"),
        approvedDate = this.approvedDate,
        lastUpdatedDate = this.updatedAt,
        orders = ordersList.map { it.toOrderItemResponse() },
        products = this.products.map { it.toInquireResponse() }
    )
}
