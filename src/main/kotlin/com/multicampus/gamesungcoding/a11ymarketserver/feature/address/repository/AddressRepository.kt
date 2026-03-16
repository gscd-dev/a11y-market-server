package com.multicampus.gamesungcoding.a11ymarketserver.feature.address.repository

import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.entity.Addresses
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AddressRepository : JpaRepository<Addresses, UUID> {
    fun findByUserUserEmailOrderByCreatedAtDesc(userEmail: String): List<Addresses>
    fun findByUserUserEmailAndIsDefaultTrue(userEmail: String): Addresses?
    fun findByAddressIdAndUserUserEmail(addressId: UUID, userEmail: String): Addresses?
    fun findAllByUserUserEmail(userEmail: String): List<Addresses>
}