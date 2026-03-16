package com.multicampus.gamesungcoding.a11ymarketserver.feature.address.dto

import java.time.LocalDateTime
import java.util.UUID

data class AddressResponse(
    val addressId: UUID,
    val userId: UUID,
    val addressName: String,
    val receiverName: String,
    val receiverPhone: String,
    val receiverZipcode: String,
    val receiverAddr1: String,
    val receiverAddr2: String?,
    val isDefault: Boolean,
    val createdAt: LocalDateTime
)