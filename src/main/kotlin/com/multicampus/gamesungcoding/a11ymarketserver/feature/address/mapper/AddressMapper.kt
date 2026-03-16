package com.multicampus.gamesungcoding.a11ymarketserver.feature.address.mapper

import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.dto.AddressResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.entity.Addresses

fun Addresses.toResponse(): AddressResponse =
    AddressResponse(
        addressId = requireNotNull(this.addressId) { "Address ID cannot be null" },
        userId = requireNotNull(this.user.userId) { "User ID cannot be null" },
        addressName = this.address.addressName,
        receiverName = this.address.receiverName,
        receiverPhone = this.address.receiverPhone,
        receiverZipcode = this.address.receiverZipcode,
        receiverAddr1 = this.address.receiverAddr1,
        receiverAddr2 = this.address.receiverAddr2,
        isDefault = this.isDefault,
        createdAt = requireNotNull(this.createdAt) { "CreatedAt cannot be null" }
    )