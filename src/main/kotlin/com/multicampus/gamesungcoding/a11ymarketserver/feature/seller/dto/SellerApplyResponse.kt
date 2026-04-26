package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.dto

import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerGrades
import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerSubmitStatus
import java.time.LocalDateTime
import java.util.UUID

data class SellerApplyResponse(
    val sellerId: UUID,
    val sellerName: String,
    val userName: String,
    val userEmail: String,
    val userPhone: String,
    val businessNumber: String,
    val sellerGrade: SellerGrades,
    val sellerIntro: String?,
    val a11yGuarantee: Boolean,
    val sellerSubmitStatus: SellerSubmitStatus,
    val submitDate: LocalDateTime,
    val approvedDate: LocalDateTime?
)
