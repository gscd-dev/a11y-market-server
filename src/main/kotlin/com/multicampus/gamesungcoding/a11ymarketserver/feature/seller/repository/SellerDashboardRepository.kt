package com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.repository

import com.multicampus.gamesungcoding.a11ymarketserver.feature.seller.entity.SellerDashboardStats
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SellerDashboardRepository : JpaRepository<SellerDashboardStats, UUID> {
    fun findBySellerId(sellerId: UUID): SellerDashboardStats?
}
