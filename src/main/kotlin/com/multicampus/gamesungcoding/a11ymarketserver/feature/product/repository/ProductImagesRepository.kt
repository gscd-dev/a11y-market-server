package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.repository

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.entity.Product
import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.entity.ProductImages
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductImagesRepository : JpaRepository<ProductImages, UUID> {
    fun findAllByProduct(product: Product): List<ProductImages>
}
