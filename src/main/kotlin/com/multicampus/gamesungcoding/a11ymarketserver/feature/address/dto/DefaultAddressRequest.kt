package com.multicampus.gamesungcoding.a11ymarketserver.feature.address.dto

import jakarta.validation.constraints.NotNull

data class DefaultAddressRequest(
    @field:NotNull(message = "addressId는 필수입니다.")
    val addressId: String
)
