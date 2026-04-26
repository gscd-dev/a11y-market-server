package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class SellerProductStockUpdateRequest(
    @field:NotNull(message = "재고 수량은 필수입니다.")
    @field:Min(value = 0, message = "재고 수량은 0 이상이어야 합니다.")
    var productStock: Int
)
