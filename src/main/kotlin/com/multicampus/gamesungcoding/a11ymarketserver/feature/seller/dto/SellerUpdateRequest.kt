package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import jakarta.validation.constraints.NotBlank

data class SellerUpdateRequest(
    @field:NotBlank val sellerName: String,
    @field:NotBlank val sellerIntro: String
)
