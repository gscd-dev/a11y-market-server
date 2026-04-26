package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerGrades
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerSubmitStatus
import java.time.LocalDateTime
import java.util.UUID

data class SellerProfileResponse(
    val sellerId: UUID,
    val sellerName: String,
    val businessNumber: String,
    val sellerGrade: SellerGrades,
    val contactEmail: String,
    val contactPhone: String,
    val storeIntro: String?,
    val isA11yGuarantee: Boolean,
    val profileStatus: SellerSubmitStatus,
    val submitDate: LocalDateTime,
    val approvedDate: LocalDateTime?,
    val lastUpdatedDate: LocalDateTime
)
