package com.multicampus.gamesungcoding.a11ymarketserver.feature.address.dto

import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class AddressRequest(
    @field:Size(max = 100, message = "주소명은 100자 이하여야 합니다.")
    val addressName: String,

    @field:Size(min = 2, max = 30, message = "수령인 이름은 2~30자여야 합니다.")
    val receiverName: String,

    @field:Pattern(regexp = "^\\d+$", message = "휴대폰 번호는 숫자여야 합니다.")
    val receiverPhone: String,

    @field:Pattern(regexp = "^\\d{5}$", message = "우편번호는 5자리 숫자여야 합니다.")
    val receiverZipcode: String,

    @field:Size(max = 100, message = "주소는 100자 이하여야 합니다.")
    val receiverAddr1: String,

    @field:Size(max = 200, message = "상세 주소는 200자 이하여야 합니다.")
    val receiverAddr2: String?,
    
    val isDefault: Boolean? = false
)
