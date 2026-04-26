package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import jakarta.validation.constraints.Min

data class SellerInquireProductRequest(
    @field:Min(0) val page: Int,
    @field:Min(10) val size: Int
)
