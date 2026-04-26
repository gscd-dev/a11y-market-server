package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import jakarta.validation.constraints.NotBlank

data class SellerApplyRequest(
    @field:NotBlank val sellerName: String,
    @field:NotBlank val businessNumber: String,
    val sellerIntro: String? = null
)
