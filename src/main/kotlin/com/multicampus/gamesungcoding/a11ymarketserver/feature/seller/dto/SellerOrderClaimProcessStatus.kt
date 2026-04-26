package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

enum class SellerOrderClaimProcessStatus {
    APPROVED,
    REJECTED;

    fun isApproved(): Boolean = this == APPROVED
}
